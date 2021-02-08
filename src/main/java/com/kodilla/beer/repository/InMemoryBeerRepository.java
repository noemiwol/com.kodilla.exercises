package com.kodilla.beer.repository;

import com.kodilla.beer.domain.Beer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBeerRepository implements BeerRepository{
    private List<Beer> beers= new ArrayList<>();

    @Override
    public List<Beer> findAll() {
        return null;
    }

    @Override
    public void save(Beer beer) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
