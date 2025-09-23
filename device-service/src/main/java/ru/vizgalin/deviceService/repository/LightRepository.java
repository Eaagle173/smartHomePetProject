package ru.vizgalin.deviceService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vizgalin.deviceService.entity.device.Light;
import ru.vizgalin.deviceService.entity.device.Room;

import java.util.Optional;

@Repository
public interface LightRepository extends JpaRepository<Light, Long> {
    Optional<Light> findByRoom(Room room);
}
