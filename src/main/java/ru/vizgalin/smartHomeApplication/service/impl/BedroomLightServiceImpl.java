package ru.vizgalin.smartHomeApplication.service.impl;

import ch.qos.logback.core.joran.conditional.IfAction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.vizgalin.smartHomeApplication.device.room.bathroom.BathroomLight;
import ru.vizgalin.smartHomeApplication.device.room.bedroom.BedroomLight;
import ru.vizgalin.smartHomeApplication.repository.BedroomRepository;
import ru.vizgalin.smartHomeApplication.service.BedroomLightService;

import java.util.Optional;

@Slf4j
@Service
public class BedroomLightServiceImpl extends LightServiceImpl<BedroomLight, Long> implements BedroomLightService {

    private final BedroomRepository bedroomRepository;

    public BedroomLightServiceImpl(JpaRepository<BedroomLight, Long> jpaRepository, BedroomRepository bedroomRepository) {
        super(jpaRepository);
        this.bedroomRepository = bedroomRepository;
    }

    @Override
    public String isWork(Boolean isOn) {
        Optional<BedroomLight> bedroomLightOptional = bedroomRepository.findById(1L);
        if (bedroomLightOptional.isPresent()) {
            BedroomLight bedroomLight = bedroomLightOptional.get();
            if (isOn) {
                bedroomLight.setWork(true);
                return "{ \"state\": \"ON\" }";
            } else {
                bedroomLight.setWork(false);
            }
        }
        return "{ \"state\": \"OFF\" }";
    }
}
