package com.kodilla.webflux;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class BookDto {
    private final int id;
    private final String title;
    private final String author;
    private final int year;
}
