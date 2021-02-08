package com.kodilla.beer.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    BeerRepository repository(){
        return new InMemoryBeerRepository();
    }
}
