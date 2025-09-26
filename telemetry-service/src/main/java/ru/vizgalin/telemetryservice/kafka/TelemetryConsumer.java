package ru.vizgalin.telemetryservice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.vizgalin.telemetryservice.repository.LightRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class TelemetryConsumer {

    private final LightRepository lightRepository;

    @KafkaListener(topics = "zigbee_telemetry")
    public void consume(String message) {
        log.info("Received telemetry message: " + message);

        String[] split = message.split(":");
        if (split.length == 2) {
            Long id = Long.valueOf(split[0]);
            String command = split[1];

            lightRepository.findById(id).ifPresent(light -> {
                light.setLightSwitch(command);
                lightRepository.save(light);
                log.info("Updated light {} -> {} ", id, command);
            });
        }
    }
}
