package com.jeena.springAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
       
       Samsung s = factory.getBean(Samsung.class);
       s.config();
    }
}
