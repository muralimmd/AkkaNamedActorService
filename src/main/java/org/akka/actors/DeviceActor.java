package org.akka.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import org.akka.actors.messages.DeviceSignalMessage;

public class DeviceActor extends AbstractLoggingActor {

    public static Props props() {
        return Props.create(DeviceActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(DeviceSignalMessage.class, m -> {
                    log().info("Got the message from device,"+m.getDeviceName());
                })
                .matchAny(o -> {
                    log().info("invalid message received by device actor");
                })
                .build();
    }
}
