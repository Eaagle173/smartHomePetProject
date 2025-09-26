package ru.vizgalin.zigbeeGateway.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandConsumer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "zigbee.commands")
    public void consume(String command) {
        System.out.println("Received command: " + command);

        kafkaTemplate.send("zigbee_telemetry", command);
        System.out.println(">>> Sent telemetry: " + command);
    }
}
