package ru.vizgalin.smartHomeApplication.service;

import ru.vizgalin.smartHomeApplication.device.room.bedroom.BedroomLight;

public interface BedroomLightService extends LightService<BedroomLight, Long> {
    public String isWork(Boolean isOn);
}
