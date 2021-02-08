package com.kodilla.beer.service;

import com.kodilla.beer.domain.Beer;

import java.util.List;

public interface BeerService {
    List<Beer> m1();
    void m2(Beer beer);
    void m3(Long id);
}
