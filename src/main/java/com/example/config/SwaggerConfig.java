package com.example.config;

import static org.springdoc.core.Constants.SPRINGDOC_ENABLED;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@ConditionalOnProperty(name = SPRINGDOC_ENABLED)
public class SwaggerConfig {
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Autowired
	private Optional<BuildProperties> buildProperties;
	
	public OpenAPI api( ) {
		return new OpenAPI().info(new Info().title("API mikroserwisu " + applicationName).version("v" + buildProperties.map(BuildProperties::getVersion).orElse("DEV.0.1")));
	}
}
