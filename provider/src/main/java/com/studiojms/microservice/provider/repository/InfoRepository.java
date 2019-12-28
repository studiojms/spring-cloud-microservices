package com.studiojms.microservice.provider.repository;

import com.studiojms.microservice.provider.model.ProviderInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jefferson.souza
 */
@Repository
public interface InfoRepository extends CrudRepository<ProviderInfo, Long> {

    ProviderInfo findByState(String state);
}
