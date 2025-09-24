package ru.vizgalin.commandService.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "zigbee.commands";

    public void sendCommand(String deviceId, String command) {
        String message = deviceId + ": " + command;
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Sent message: " + message);
    }
}
