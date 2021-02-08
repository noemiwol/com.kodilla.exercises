package com.kodilla.beer.repository;

import com.kodilla.beer.domain.Beer;

import java.util.List;

public interface BeerRepository {
    List<Beer> findAll();
    void save(Beer beer);
    void deleteById(Long id);
}
