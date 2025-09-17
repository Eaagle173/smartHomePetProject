package ru.vizgalin.smartHomeApplication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vizgalin.smartHomeApplication.facade.LightControlFacade;

@Validated
@Slf4j
@RequestMapping("/light")
@RequiredArgsConstructor
@RestController
public class LightController {
    private final LightControlFacade lightControlFacade;


}
