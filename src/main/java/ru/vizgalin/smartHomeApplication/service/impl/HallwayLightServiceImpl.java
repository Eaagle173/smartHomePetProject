package ru.vizgalin.smartHomeApplication.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.vizgalin.smartHomeApplication.device.room.hallway.HallwayLight;
import ru.vizgalin.smartHomeApplication.repository.HallwayLightRepository;
import ru.vizgalin.smartHomeApplication.service.HallwayLightService;

import java.util.Optional;

@Slf4j
@Service
public class HallwayLightServiceImpl extends LightServiceImpl<HallwayLight, Long> implements HallwayLightService {

    HallwayLightRepository hallwayLightRepository;

    public HallwayLightServiceImpl(JpaRepository<HallwayLight, Long> jpaRepository, HallwayLightRepository hallwayLightRepository) {
        super(jpaRepository);
        this.hallwayLightRepository = hallwayLightRepository;
    }

    @Override
    public String isWork(Boolean isOn) {
        Optional<HallwayLight> hallwayLightOptional = hallwayLightRepository.findById(1L);
        if (hallwayLightOptional.isPresent()) {
            HallwayLight hallwayLight = hallwayLightOptional.get();
            if (isOn) {
                hallwayLight.setWork(true);
                return "{ \"state\": \"ON\" }";
            } else {
                hallwayLight.setWork(false);
            }
        }
        return "{ \"state\": \"OFF\" }";
    }
}
