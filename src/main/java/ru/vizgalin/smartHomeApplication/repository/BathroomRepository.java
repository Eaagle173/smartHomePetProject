package ru.vizgalin.smartHomeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vizgalin.smartHomeApplication.device.room.bathroom.BathroomLight;

@Repository
public interface BathroomRepository extends JpaRepository<BathroomLight, Long> {
}
