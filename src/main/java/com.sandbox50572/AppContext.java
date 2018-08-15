package com.sandbox50572;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
*  Model
*
*/

public class AppContext implements ServletContextListener{



    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext context = servletContextEvent.getServletContext ();
        try {
            context.setAttribute ("upTime", System.currentTimeMillis ());//установка текущего времени в ключ upTime
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
