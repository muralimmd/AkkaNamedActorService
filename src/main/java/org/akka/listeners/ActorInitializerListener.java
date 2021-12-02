package org.akka.listeners;

import org.akka.actors.DeviceActorSystem;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component
public class ActorInitializerListener implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        DeviceActorSystem.initialize();
    }

    @Override
    public void destroy() throws Exception {
        DeviceActorSystem.destroy();
    }
}
