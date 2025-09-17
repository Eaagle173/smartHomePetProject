package ru.vizgalin.smartHomeApplication.service;

import ru.vizgalin.smartHomeApplication.device.room.bathroom.BathroomLight;

public interface BathroomLightService extends LightService<BathroomLight, Long> {
    String isWork(Boolean b);
}
