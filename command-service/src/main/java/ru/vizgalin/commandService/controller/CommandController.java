package ru.vizgalin.commandService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vizgalin.commandService.service.CommandProducer;

@RequiredArgsConstructor
@RequestMapping("/commands")
@RestController
public class CommandController {

    private final CommandProducer commandProducer;

    @PostMapping("/{deviceId}")
    public String sendCommand(@PathVariable String deviceId, @RequestParam String command) {
        commandProducer.sendCommand(deviceId, command);
        return "Command '" + command + "' sent to device " + deviceId;
    }
}
