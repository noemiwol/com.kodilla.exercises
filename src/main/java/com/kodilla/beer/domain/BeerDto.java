package com.kodilla.beer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BeerDto {
    Long id;
    String name;
    Double abv;
}
