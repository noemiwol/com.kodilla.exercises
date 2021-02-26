package com.kodilla.proxyWeather.db;

public interface DbWeatherDataRetriever {
    String getWeather() throws InterruptedException;

    String refreshData() throws InterruptedException;
}
