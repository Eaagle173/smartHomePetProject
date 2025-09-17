package ru.vizgalin.smartHomeApplication.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.vizgalin.smartHomeApplication.device.room.bathroom.BathroomLight;
import ru.vizgalin.smartHomeApplication.repository.BathroomRepository;
import ru.vizgalin.smartHomeApplication.service.BathroomLightService;
import ru.vizgalin.smartHomeApplication.service.LightService;

import java.util.Optional;

@Slf4j
@Service
public class BathroomLightServiceImpl extends LightServiceImpl<BathroomLight, Long> implements BathroomLightService {

    private final BathroomRepository bathroomRepository;

    public BathroomLightServiceImpl(JpaRepository<BathroomLight, Long> jpaRepository, BathroomRepository bathroomRepository) {
        super(jpaRepository);
        this.bathroomRepository = bathroomRepository;
    }

    @Override
    public String isWork(Boolean isOn) {
        Optional<BathroomLight> bathroomLightOptional = bathroomRepository.findById(1L);
        if (bathroomLightOptional.isPresent()) {
            BathroomLight bathroomLight = bathroomLightOptional.get();
            if (isOn) {
                bathroomLight.setWork(true);
                return "{ \"state\": \"ON\" }";
            } else {
                bathroomLight.setWork(false);
            }
        }
        return "{ \"state\": \"OFF\" }";
    }
}
