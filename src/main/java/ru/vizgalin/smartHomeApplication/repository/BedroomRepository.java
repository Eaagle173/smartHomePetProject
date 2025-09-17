package ru.vizgalin.smartHomeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vizgalin.smartHomeApplication.device.room.bedroom.BedroomLight;

@Repository
public interface BedroomRepository extends JpaRepository<BedroomLight, Long> {
}
