package ru.vizgalin.smartHomeApplication.service;

import ru.vizgalin.smartHomeApplication.device.room.hallway.HallwayLight;

public interface HallwayLightService extends LightService<HallwayLight, Long> {
    public String isWork(Boolean isOn);
}
