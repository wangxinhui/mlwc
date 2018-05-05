/*
SQLyog Trial v12.3.3 (64 bit)
MySQL - 5.7.16 : Database - mlwc
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `mlwc_log` */

DROP TABLE IF EXISTS `mlwc_log`;

CREATE TABLE `mlwc_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `description` varchar(100) DEFAULT NULL COMMENT '操作描述',
  `username` varchar(20) DEFAULT NULL COMMENT '操作用户',
  `start_time` bigint(20) DEFAULT NULL COMMENT '操作时间',
  `spend_time` int(11) DEFAULT NULL COMMENT '消耗时间',
  `base_path` varchar(500) DEFAULT NULL COMMENT '根路径',
  `uri` varchar(500) DEFAULT NULL COMMENT 'URI',
  `url` varchar(500) DEFAULT NULL COMMENT 'URL',
  `method` varchar(10) DEFAULT NULL COMMENT '请求类型',
  `parameter` mediumtext,
  `user_agent` varchar(500) DEFAULT NULL COMMENT '用户标识',
  `ip` varchar(30) DEFAULT NULL COMMENT 'IP地址',
  `result` mediumtext,
  `permissions` varchar(100) DEFAULT NULL COMMENT '权限值',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';

/*Data for the table `mlwc_log` */

/*Table structure for table `mlwc_permission` */

DROP TABLE IF EXISTS `mlwc_permission`;

CREATE TABLE `mlwc_permission` (
  `permission_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `system_id` int(10) unsigned NOT NULL COMMENT '所属系统',
  `pid` int(10) DEFAULT NULL COMMENT '所属上级',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型(1:目录,2:菜单,3:按钮)',
  `permission_value` varchar(50) DEFAULT NULL COMMENT '权限值',
  `uri` varchar(100) DEFAULT NULL COMMENT '路径',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `ctime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `orders` bigint(20) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限';

/*Data for the table `mlwc_permission` */

/*Table structure for table `mlwc_role` */

DROP TABLE IF EXISTS `mlwc_role`;

CREATE TABLE `mlwc_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT 'role name',
  `title` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `ctime` bigint(20) DEFAULT NULL,
  `orders` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `mlwc_role` */

/*Table structure for table `mlwc_role_permission` */

DROP TABLE IF EXISTS `mlwc_role_permission`;

CREATE TABLE `mlwc_role_permission` (
  `role_permission_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色编号',
  `permission_id` int(10) unsigned NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`role_permission_id`),
  KEY `FK_Reference_23` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

/*Data for the table `mlwc_role_permission` */

/*Table structure for table `mlwc_user` */

DROP TABLE IF EXISTS `mlwc_user`;

CREATE TABLE `mlwc_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL,
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `realname` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `locked` tinyint(4) DEFAULT NULL,
  `ctime` bigint(20) DEFAULT NULL COMMENT '新建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `mlwc_user` */

/*Table structure for table `mlwc_user_persission` */

DROP TABLE IF EXISTS `mlwc_user_persission`;

CREATE TABLE `mlwc_user_persission` (
  `user_persission_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT NULL,
  `permisision_id` int(10) unsigned DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_persission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mlwc_user_persission` */

/*Table structure for table `mlwc_user_role` */

DROP TABLE IF EXISTS `mlwc_user_role`;

CREATE TABLE `mlwc_user_role` (
  `user_role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mlwc_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

/* 树形查询 */
DELIMITER $$

USE `mlwc`$$

DROP FUNCTION IF EXISTS `getChildList`$$

CREATE DEFINER=`mlwc`@`localhost` FUNCTION `getChildList`(rootId INT) RETURNS VARCHAR(1000) CHARSET utf8
    DETERMINISTIC
BEGIN
    DECLARE sTemp VARCHAR(1000);
    DECLARE sTempChild VARCHAR(1000);

    SET sTemp = '$';
    SET sTempChild = CAST(rootId AS CHAR);

    WHILE sTempChild IS NOT NULL DO
      SET sTemp = CONCAT(sTemp,',',sTempChild);
      SELECT GROUP_CONCAT(permission_id) INTO sTempChild FROM mlwc_permission WHERE FIND_IN_SET(pid,sTempChild) >0;
    END WHILE;
    RETURN sTemp;
  END$$

DELIMITER ;



