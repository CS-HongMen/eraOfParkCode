package com.iFox.utils;

import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by exphuhong on 17-9-14.
 * Start
 */

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        TokenCheck tokenCheck = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext())
                .getBean(TokenCheck.class);
        tokenCheck.execute();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
