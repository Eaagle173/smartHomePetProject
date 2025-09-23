package ru.vizgalin.deviceService.service;


import ru.vizgalin.deviceService.entity.device.Light;

public interface LightService extends AbstractService<Light, Long> {
    public String switchOn(String room);

    public String switchOff(String room);

    public void createLightsRoom (String nameRoom);
}
