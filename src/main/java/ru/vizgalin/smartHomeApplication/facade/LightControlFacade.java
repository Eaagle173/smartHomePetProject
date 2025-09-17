package ru.vizgalin.smartHomeApplication.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vizgalin.smartHomeApplication.service.BathroomLightService;
import ru.vizgalin.smartHomeApplication.service.BedroomLightService;
import ru.vizgalin.smartHomeApplication.service.HallwayLightService;
import ru.vizgalin.smartHomeApplication.service.KitchenLightService;
import ru.vizgalin.smartHomeApplication.service.ToiletLightService;

@Service
@RequiredArgsConstructor
@Slf4j
public class LightControlFacade {
    private final BathroomLightService bathroomService;
    private final BedroomLightService bedroomService;
    private final HallwayLightService hallwayService;
    private final KitchenLightService kitchenService;
    private final ToiletLightService toiletLightService;

    public String bathroomLightTurn(boolean on) {
        return bathroomService.isWork(on);
    }

    public String bedroomLightTurn(boolean on) {
        return bedroomService.isWork(on);
    }

    public String hallwayLightTurn(boolean on) {
        return hallwayService.isWork(on);
    }

    public String kitchenLightTurn(boolean on) {
        return kitchenService.isWork(on);
    }

    public String toiletLightTurn(boolean on) {
        return toiletLightService.isWork(on);
    }
}
