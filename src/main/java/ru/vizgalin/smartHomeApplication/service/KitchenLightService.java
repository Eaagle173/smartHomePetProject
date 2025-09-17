package ru.vizgalin.smartHomeApplication.service;

import ru.vizgalin.smartHomeApplication.device.room.kichen.KitchenLight;

public interface KitchenLightService extends LightService<KitchenLight, Long> {
    public String isWork(Boolean isOn);
}
