package ru.vizgalin.telemetryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vizgalin.telemetryservice.entity.Light;

public interface LightRepository extends JpaRepository<Light, Long> {
}
