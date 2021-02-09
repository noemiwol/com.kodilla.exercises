package com.kodilla.beer.service;

import com.kodilla.beer.domain.Beer;
import com.kodilla.beer.repository.BeerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService{
    private final BeerRepository repository;

    @Override
    public List<Beer> m1() {
        return repository.m1();
    }

    @Override
    public void m2(Beer beer) {
        repository.m2(beer);

    }

    @Override
    public void m3(Long id) {
        repository.m3(id);

    }
}
