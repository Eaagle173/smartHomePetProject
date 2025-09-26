package ru.vizgalin.deviceService.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vizgalin.deviceService.dto.CommandRequest;
import ru.vizgalin.deviceService.entity.device.Light;
import ru.vizgalin.deviceService.kafka.CommandProducer;
import ru.vizgalin.deviceService.repository.LightRepository;
import ru.vizgalin.deviceService.service.LightService;

@Service
@Slf4j
public class LightServiceImpl extends AbstractServiceImpl<Light, Long> implements LightService {

    private final LightRepository lightRepository;
    private final CommandProducer commandProducer;

    public LightServiceImpl(JpaRepository<Light, Long> jpaRepository, LightRepository lightRepository, CommandProducer commandProducer) {
        super(jpaRepository);
        this.lightRepository = lightRepository;
        this.commandProducer = commandProducer;
    }

    @Override
    @Transactional
    public String switchOn(String room) {
        Light light = lightRepository.findByRoom(room.toUpperCase()).orElseThrow(() -> new RuntimeException("Room not found " + room));
        commandProducer.sendCommand(new CommandRequest(light.getId().toString(), "ON"));
        return "Command sent to turn ON light in " + room;
    }

    @Override
    @Transactional
    public String switchOff(String room) {
        Light light = lightRepository.findByRoom(room.toUpperCase()).orElseThrow(() -> new RuntimeException("Room not found " + room));
        commandProducer.sendCommand(new CommandRequest(light.getId().toString(), "OFF"));
        return "Command sent to turn OFF light in " + room;
    }

    @Override
    @Transactional
    public void createLightsRoom(String nameRoom) {
        Light light = new Light();
        light.setRoom(nameRoom.toUpperCase());
        light.setLightSwitch("OFF");
        save(light);
        log.info("Creating Lights Room");
    }
}
