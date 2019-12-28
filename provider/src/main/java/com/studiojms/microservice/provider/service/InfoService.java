package com.studiojms.microservice.provider.service;

import com.studiojms.microservice.provider.model.ProviderInfo;
import com.studiojms.microservice.provider.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jefferson.souza
 */
@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public ProviderInfo getInfoByState(String state) {
        return infoRepository.findByState(state);
    }
}
