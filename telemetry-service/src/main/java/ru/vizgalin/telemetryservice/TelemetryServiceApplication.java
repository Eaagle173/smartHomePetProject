package ru.vizgalin.telemetryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class TelemetryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelemetryServiceApplication.class, args);
    }

}
