package org.akka;

import org.akka.listeners.ActorStartupListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.ServletContextListener;

/**
 * Selecting Actors from system via Named Actor Feature
 *
 */
@SpringBootApplication
public class BootingApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(BootingApp.class, args);
        System.out.println( "Akka Names Actors app started............." );
    }

   /* @Bean
    ServletListenerRegistrationBean<ServletContextListener> servletListener() {
        ServletListenerRegistrationBean<ServletContextListener> srb
                = new ServletListenerRegistrationBean<>();
        srb.setListener(new ActorStartupListener());
        return srb;
    }*/
}
