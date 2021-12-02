package org.akka.controllers;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import org.akka.actors.DeviceActorSystem;
import org.akka.actors.messages.DeviceSignalMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeviceRestController {

    @RequestMapping(path = "/{deviceName}/device.execute", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> runDevice(@PathVariable("deviceName") String deviceName) {
        try {
            DeviceSignalMessage message= new DeviceSignalMessage(deviceName, deviceName, Double.valueOf(25.6));
            ActorSelection selection = DeviceActorSystem.getDeviceActor(deviceName);
            selection.tell(message, ActorRef.noSender());
            return new ResponseEntity("device - "+deviceName+": started successfully",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Invalid device number, "+deviceName, HttpStatus.BAD_REQUEST);
        }

    }

}
