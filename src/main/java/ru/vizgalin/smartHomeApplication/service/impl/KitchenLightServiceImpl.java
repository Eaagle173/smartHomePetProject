package ru.vizgalin.smartHomeApplication.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.vizgalin.smartHomeApplication.device.room.kichen.KitchenLight;
import ru.vizgalin.smartHomeApplication.repository.KitchenRepository;
import ru.vizgalin.smartHomeApplication.service.KitchenLightService;

import java.util.Optional;

@Slf4j
@Service
public class KitchenLightServiceImpl extends LightServiceImpl<KitchenLight, Long> implements KitchenLightService {
    private final KitchenRepository kitchenRepository;

    public KitchenLightServiceImpl(JpaRepository<KitchenLight, Long> jpaRepository, KitchenRepository kitchenRepository) {
        super(jpaRepository);
        this.kitchenRepository = kitchenRepository;
    }

    @Override
    public String isWork(Boolean isOn) {
        Optional<KitchenLight> kitchenLightOptional = kitchenRepository.findById(1L);
        if (kitchenLightOptional.isPresent()) {
            KitchenLight kitchenLight = kitchenLightOptional.get();
            if (isOn) {
                kitchenLight.setWork(true);
                return "{ \"state\": \"ON\" }";
            } else {
                kitchenLight.setWork(false);
            }
        }
        return "{ \"state\": \"OFF\" }";
    }
}
