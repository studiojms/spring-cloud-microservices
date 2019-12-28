package com.studiojms.microservice.provider.controller;

import com.studiojms.microservice.provider.model.ProviderInfo;
import com.studiojms.microservice.provider.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jefferson.souza
 */
@RestController
@RequestMapping("/info")
public class InfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private InfoService infoService;

    @GetMapping("/{state}")
    public ProviderInfo getInfoByState(@PathVariable String state) {
        LOGGER.info("Received request from provider from {}", state);

        return infoService.getInfoByState(state);
    }
}
