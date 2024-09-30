package com.example.mxhfullstack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	private AppConfig appConfig;
	
	@Autowired
	public WebMvcConfig(AppConfig appConfig) {
		this.appConfig = appConfig;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/**");
	}
	@Bean
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor(appConfig);
	}
}
