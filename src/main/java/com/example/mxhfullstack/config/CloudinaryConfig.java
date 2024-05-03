package com.example.mxhfullstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "doeiwein1",
                "api_key","593628465349715",
                "api_secret","FKRpbNh3APrjnFLhEEDkYPPOVXY",
                "secure",true
        ));	
        return cloudinary;
    }
}
