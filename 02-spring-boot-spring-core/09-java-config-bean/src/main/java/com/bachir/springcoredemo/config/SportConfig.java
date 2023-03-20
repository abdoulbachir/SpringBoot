package com.bachir.springcoredemo.config;

import com.bachir.springcoredemo.common.Coach;
import com.bachir.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    //Configure a bean
    @Bean("yoyoyo")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
