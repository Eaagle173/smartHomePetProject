package ru.vizgalin.smartHomeApplication.service;

import ru.vizgalin.smartHomeApplication.device.room.toilet.ToiletLight;

public interface ToiletLightService extends LightService<ToiletLight, Long> {
    public String isWork(Boolean isOn);
}
