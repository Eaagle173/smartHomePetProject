package ru.vizgalin.smartHomeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vizgalin.smartHomeApplication.device.room.kichen.KitchenLight;

@Repository
public interface KitchenRepository extends JpaRepository<KitchenLight, Long> {
}
