package ru.vizgalin.smartHomeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vizgalin.smartHomeApplication.device.room.toilet.ToiletLight;

@Repository
public interface ToiletRepository extends JpaRepository<ToiletLight, Long> {
}
