package com.example.libraryspring_mvc;

import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("classpath:books.xml classpath:libraryAppContext.xml classpath:chapters.xml classpath:titles.xml");

        ServletRegistration.Dynamic dispatcher = servletContext
                .addServlet("dispatcher", new DispatcherServlet(context));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
