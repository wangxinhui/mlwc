package com.mlwc.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.net.URLDecoder;

/**
 * @Author: by simple on 2018/4/12.
 * 用来解压
 */
public class MlwcUI implements InitializingBean, ServletContextAware {

    public static final Logger LOGGER = LoggerFactory.getLogger(MlwcUI.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("mlwcui afterPropertiesSet!");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        String rootPath = this.getClass().getClassLoader().getResource("/").getPath();
        String fullPath = "";
        String pathArr[] = rootPath.split("/WEB-INF/classes/");
        System.out.println(fullPath);
        System.out.println(pathArr[0]);
        fullPath = pathArr[0];
        LOGGER.info("---------start decompress the jar-----------" + fullPath + "-----");
        String version = PropertiesFileUtil.getInstance("mlwc-ui-version").get("mlwc.ui.version");
        LOGGER.info("---------mlwc-ui-version:{}--------", version);
        String jarPath = fullPath + "/WEB-INF/lib/mlwc-UI-" + version + ".jar";
        LOGGER.info("---------mlwc-ui path : {}", jarPath);
        String resourcePath = fullPath + "/resources/mlwc-ui";
        LOGGER.info("------mlwc-ui.jar decompress to : {} " + resourcePath);
        JarUtil.decompress(jarPath, resourcePath);
        LOGGER.info("---- mlwc ui complete");
    }
}
