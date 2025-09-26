package ru.vizgalin.deviceService.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.vizgalin.deviceService.dto.CommandRequest;

@Service
@RequiredArgsConstructor
public class CommandProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendCommand(CommandRequest commandRequest) {
        String message = commandRequest.deviceId() + ":" + commandRequest.command();
        kafkaTemplate.send("zigbee.commands", message);
    }
}
