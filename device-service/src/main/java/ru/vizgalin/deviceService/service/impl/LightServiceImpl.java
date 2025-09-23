package ru.vizgalin.deviceService.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vizgalin.deviceService.entity.device.Light;
import ru.vizgalin.deviceService.entity.device.LightSwitch;
import ru.vizgalin.deviceService.entity.device.Room;
import ru.vizgalin.deviceService.repository.LightRepository;
import ru.vizgalin.deviceService.service.LightService;

import java.util.Optional;

@Service
@Slf4j
public class LightServiceImpl extends AbstractServiceImpl<Light, Long> implements LightService {

    private final LightRepository lightRepository;

    public LightServiceImpl(JpaRepository<Light, Long> jpaRepository, LightRepository lightRepository) {
        super(jpaRepository);
        this.lightRepository = lightRepository;
    }

    @Override
    @Transactional
    public String switchOn(String room) {
        Room room1 = Room.valueOf(room.toUpperCase());
        Optional<Light> lightOptional = lightRepository.findByRoom(room1);
        if (lightOptional.isPresent()) {
            log.info("Switching light on " + room);
            lightOptional.get().setLightSwitch(LightSwitch.ON);
            update(lightOptional.get());
            return "{ \"state\": \"ON\" }";
        }
        log.warn("Room " + room + " not found");
        return null;
    }

    @Override
    @Transactional
    public String switchOff(String room) {
        Room room1 = Room.valueOf(room.toUpperCase());
        Optional<Light> lightOptional = lightRepository.findByRoom(room1);
        if (lightOptional.isPresent()) {
            lightOptional.get().setLightSwitch(LightSwitch.OFF);
            update(lightOptional.get());
            return "{ \"state\": \"OFF\" }";
        }
        log.warn("Room " + room + " not found");
        return null;
    }

    @Override
    @Transactional
    public void createLightsRoom (String nameRoom) {
        Room room1 = Room.valueOf(nameRoom.toUpperCase());
        Light light = new Light();
        light.setRoom(room1);
        light.setLightSwitch(LightSwitch.OFF);
        save(light);
        log.info("Creating Lights Room");
    }
}
