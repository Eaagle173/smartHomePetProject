package ru.vizgalin.smartHomeApplication.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.vizgalin.smartHomeApplication.device.room.toilet.ToiletLight;
import ru.vizgalin.smartHomeApplication.repository.ToiletRepository;
import ru.vizgalin.smartHomeApplication.service.ToiletLightService;

import java.util.Optional;

@Slf4j
@Service
public class ToiletLightServiceImpl extends LightServiceImpl<ToiletLight, Long> implements ToiletLightService {
    private final ToiletRepository toiletRepository;

    public ToiletLightServiceImpl(JpaRepository<ToiletLight, Long> jpaRepository, ToiletRepository toiletRepository) {
        super(jpaRepository);
        this.toiletRepository = toiletRepository;
    }

    @Override
    public String isWork(Boolean isOn) {
        Optional<ToiletLight> toiletLightOptional = toiletRepository.findById(1L);
        if (toiletLightOptional.isPresent()) {
            ToiletLight toiletLight = toiletLightOptional.get();
            if (isOn) {
                toiletLight.setWork(true);
                return "{ \"state\": \"ON\" }";
            } else {
                toiletLight.setWork(false);
            }
        }
        return "{ \"state\": \"OFF\" }";
    }
}
