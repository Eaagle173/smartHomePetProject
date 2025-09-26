package ru.vizgalin.deviceService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vizgalin.deviceService.facade.LightControllerFacade;

@Validated
@Slf4j
@RequestMapping("/light")
@RequiredArgsConstructor
@RestController
public class LightController {
    private final LightControllerFacade lightControllerFacade;


    @PostMapping("/turnLightOnInRoom")
    public ResponseEntity<String> lightTurnOn(@RequestParam String room) {
        return ResponseEntity.ok(lightControllerFacade.switchOn(room));
    }

    @PostMapping("/turnLightOffInRoom")
    public ResponseEntity<String> turnOffLight(@RequestParam String room) {
        return ResponseEntity.ok(lightControllerFacade.switchOff(room));
    }

    @PostMapping("/createLightsRoom")
    public ResponseEntity<String> createLightsRoom(@RequestParam String room) {
        lightControllerFacade.createLightsRoom(room);
        return ResponseEntity.ok("Room created");
    }
}
