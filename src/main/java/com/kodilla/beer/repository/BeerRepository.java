package com.kodilla.beer.repository;

import com.kodilla.beer.domain.Beer;

import java.util.List;

public interface BeerRepository {
    List<Beer> m1();
    void m2(Beer beer);
    void m3(Long id);
}
