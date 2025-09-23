package ru.vizgalin.deviceService.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vizgalin.deviceService.service.LightService;

@Service
@RequiredArgsConstructor
@Slf4j
public class LightControllerFacade {
    private final LightService lightService;

    public String switchOn(String room) {
        log.info("Switching light on room " + room);
        return lightService.switchOn(room);
    }

    public String switchOff(String room) {
        log.info("Switching light off room " + room);
        return lightService.switchOff(room);
    }

    public void createLightsRoom (String nameRoom) {
        log.info("Creating Lights Room");
        lightService.createLightsRoom(nameRoom);
        log.info("Lights Room created");
    }
}
