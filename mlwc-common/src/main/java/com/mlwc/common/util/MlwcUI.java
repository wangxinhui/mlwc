package com.mlwc.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 *
 * @Author: by simple on 2018/4/12.
 * desp
 */
public class MlwcUI implements InitializingBean,ServletContextAware{

    public static final Logger LOGGER = LoggerFactory.getLogger(MlwcUI.class);

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        LOGGER.info("---------start decompress the jar----------------");


    }
}
