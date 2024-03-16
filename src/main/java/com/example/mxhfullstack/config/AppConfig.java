package com.example.mxhfullstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.mxhfullstack.model.Cookie;

@Configuration
public class AppConfig {
    @Bean
    @Scope("session")
    public Cookie cookieStore() {
        return new Cookie();
    }
}
