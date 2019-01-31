package com.example.gatewayservice.configuration;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public FallbackProvider defaultZuulFallbackProfider() {
		return new GatewayFallBack();
	}

}
