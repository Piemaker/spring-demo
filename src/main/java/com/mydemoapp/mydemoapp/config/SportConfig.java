package com.mydemoapp.mydemoapp.config;

import com.mydemoapp.mydemoapp.common.Coach;
import com.mydemoapp.mydemoapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    // the bean id default to the method name (qualifier name)
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}

