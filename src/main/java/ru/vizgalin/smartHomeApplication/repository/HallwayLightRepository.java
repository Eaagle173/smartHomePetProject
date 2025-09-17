package ru.vizgalin.smartHomeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vizgalin.smartHomeApplication.device.room.hallway.HallwayLight;

public interface HallwayLightRepository extends JpaRepository<HallwayLight, Long> {
}
