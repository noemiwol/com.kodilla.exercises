package com.kodilla.beer.controller;

import com.kodilla.beer.domain.BeerDto;
import com.kodilla.beer.mapper.BeerMapper;
import com.kodilla.beer.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/beer/")
@SessionAttributes("beer")
class BeerController {

    @Autowired
    BeerService service;
    //private final BeerService service;

    @GetMapping
    public List<BeerDto> getBeers() {
        return BeerMapper.toBeerDtoList(service.m1());
    }

    @PostMapping
    public void addBeer(@RequestBody BeerDto beerDto) {
        service.m2(BeerMapper.toBeer(beerDto));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBeer(@PathVariable("id") Long id) {
        service.m3(id);
    }

}
