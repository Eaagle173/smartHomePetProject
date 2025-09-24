package ru.vizgalin.zigbeeGateway.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CommandConsumer {

    @KafkaListener(topics = "zigbee.commands")
    public void consume(String command) {
        System.out.println("Received command: " + command);
    }
}
