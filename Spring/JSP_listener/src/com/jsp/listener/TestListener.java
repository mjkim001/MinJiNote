package com.jsp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent ctxEvent)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent ctxEvent)  { 
         ServletContext ctx = ctxEvent.getServletContext();
         
         String param1 = ctx.getInitParameter("testParam");
         System.out.println(param1);
         
         String param2 = ctx.getInitParameter("StringToken");
         System.out.println(param2);
         
         String[] strArray = param2.split(",");
         
         for(String temp : strArray)
        	 System.out.println(temp);
    }
	
}
