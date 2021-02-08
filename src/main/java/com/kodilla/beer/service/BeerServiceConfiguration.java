package com.kodilla.beer.service;

import com.kodilla.beer.repository.BeerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeerServiceConfiguration {

    @Bean
    BeerService beerService(BeerRepository repository){
        return new BeerServiceImpl(repository);
    }
}
