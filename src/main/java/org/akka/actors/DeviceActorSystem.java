package org.akka.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeviceActorSystem {
    private static Logger LOGGER = LoggerFactory.getLogger(DeviceActorSystem.class);

    private static ActorSystem actorSystem;

    public static void initialize() {
        if(actorSystem== null) {
            actorSystem = ActorSystem.create("deviceActorSystem");
            ActorRef device1 = actorSystem.actorOf(DeviceActor.props(), "device1");
            ActorRef device2 = actorSystem.actorOf(DeviceActor.props(), "device2");
            LOGGER.info("Created the actor system");
        }
    }

    public static ActorSelection getDeviceActor(String deviceName) {
        return actorSystem.actorSelection("akka://deviceActorSystem/user/"+deviceName);
    }
    public static void destroy() {
        if(actorSystem != null) {
            actorSystem.terminate();
            LOGGER.info("Terminated the actor system");

        }
    }
}
