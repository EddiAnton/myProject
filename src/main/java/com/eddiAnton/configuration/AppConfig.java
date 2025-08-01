package com.eddiAnton.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.eddiAnton")
@Import(AopConfig.class)
public class AppConfig {
}
