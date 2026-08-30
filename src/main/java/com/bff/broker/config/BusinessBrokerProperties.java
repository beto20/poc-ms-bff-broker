package com.bff.broker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration for the downstream business-broker service.
 */
@ConfigurationProperties(prefix = "business-broker")
public record BusinessBrokerProperties(String baseUrl) {
}
