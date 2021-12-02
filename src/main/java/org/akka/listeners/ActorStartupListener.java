package org.akka.listeners;

import org.akka.actors.DeviceActorSystem;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Component
@WebListener
public class ActorStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DeviceActorSystem.initialize();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        DeviceActorSystem.destroy();
    }
}
