package com.eministerios.www.system.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.eministerios.www.business")
@EnableJpaRepositories(basePackages = "com.eministerios.www.business.repository")
public class ApplicationConfiguration {
}
