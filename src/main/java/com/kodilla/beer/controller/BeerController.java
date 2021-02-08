package com.kodilla.beer.controller;

import com.kodilla.beer.domain.BeerDto;
import com.kodilla.beer.mapper.BeerMapper;
import com.kodilla.beer.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/beer/")
class BeerController {

    private final BeerService service;

    @GetMapping
    public List<BeerDto> getBooks() {
        return BeerMapper.toBeerDtoList(service.m1());
    }

    @PostMapping
    public void createBeer(@RequestBody BeerDto beerDto) {
        service.m2(BeerMapper.toBeer(beerDto));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBeer(@PathVariable("id") Long id) {
        service.m3(id);
    }

}
