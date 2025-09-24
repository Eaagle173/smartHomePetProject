package ru.vizgalin.zigbeeGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ZigbeeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZigbeeGatewayApplication.class, args);
    }

}
