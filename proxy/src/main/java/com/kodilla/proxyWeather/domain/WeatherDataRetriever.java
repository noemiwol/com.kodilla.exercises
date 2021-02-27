package com.kodilla.proxyWeather.domain;

import com.kodilla.proxyWeather.db.DbWeatherDataRetriever;

public class WeatherDataRetriever implements DbWeatherDataRetriever {
    public WeatherDataRetriever() throws InterruptedException {
        Thread.sleep(5000);
    }
    @Override
    public String getWeather() throws InterruptedException {
        return "Weather forecast for today will by sunny!";
    }

    @Override
    public String refreshData() throws InterruptedException {
        return "Weather forecast for today will  be cold!";
    }
}
