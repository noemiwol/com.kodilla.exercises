package com.kodilla.beer.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Beer {
    Long id;
    String name;
    Double abv;
}
