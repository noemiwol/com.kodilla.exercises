package com.kodilla.beer.repository;

import com.kodilla.beer.domain.Beer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBeerRepository implements BeerRepository{
    private List<Beer> beers= new ArrayList<>();

    @Override
    public List<Beer> m1() {
        return null;
    }

    @Override
    public void m2(Beer beer) {

    }

    @Override
    public void m3(Long id) {

    }
}
