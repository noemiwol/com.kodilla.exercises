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
        return repository.findAll();
    }

    @Override
    public void m2(Beer beer) {
        repository.save(beer);

    }

    @Override
    public void m3(Long id) {
        repository.deleteById(id);

    }
}
