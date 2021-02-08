package com.kodilla.beer.mapper;

import com.kodilla.beer.domain.Beer;
import com.kodilla.beer.domain.BeerDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BeerMapper {

    public static Beer toBeer(BeerDto beerDto){
        return Beer.of(beerDto.getId(), beerDto.getName(),beerDto.getAbv());
    }

    public static BeerDto beerDto(Beer beer){
        return new BeerDto(beer.getId(),beer.getName(),beer.getAbv());
    }

    public static List<Beer> toBeerList(List<BeerDto>beerDtos){
        return beerDtos
                .stream()
                .map(bdto->Beer.of(bdto.getId(), bdto.getName(),bdto.getAbv()))
                .collect(toList());
    }

    public static List<BeerDto> toBeerDtoList(List<Beer>beers){
        return beers
                .stream()
                .map(b ->new BeerDto(b.getId(),b.getName(), b.getAbv()))
                .collect(toList());
    }


}
