package com.kodilla.proxyWeather.db;

public class WeatherDataRetriever implements DbWeatherDataRetriever {
    @Override
    public String getWeather() throws InterruptedException {
        return "Weather forecast for today will by sunny!";
    }

    @Override
    public String refreshData() throws InterruptedException {
        return "Weather forecast for today will  be cold!";
    }
}
