package org.akka.actors.messages;

import java.io.Serializable;

public class DeviceSignalMessage implements Serializable {

    final String deviceName;
    final String deviceDescription;
    final Double temperature;

    public DeviceSignalMessage(String deviceName, String deviceDescription, Double temperature) {
        this.deviceName = deviceName;
        this.deviceDescription = deviceDescription;
        this.temperature = temperature;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public Double getTemperature() {
        return temperature;
    }
}
