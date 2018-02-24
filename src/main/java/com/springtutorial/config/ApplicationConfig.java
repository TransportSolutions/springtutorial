package com.springtutorial.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by agrewal on 2/23/18.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.springtutorial.backend.persistence.repositories")
@EntityScan(basePackages = "com.springtutorial.backend.persistence.domain.backend")
@EnableTransactionManagement
@PropertySource("file:///${user.home}/truck-solutions/springtutorial/application-common.properties")
public class ApplicationConfig {
}
