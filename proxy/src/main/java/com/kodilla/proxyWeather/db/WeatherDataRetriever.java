package com.kodilla.proxyWeather.db;

public class WeatherDataRetriever implements DbWeatherDataRetriever {
    public WeatherDataRetriever() throws InterruptedException {
        Thread.sleep(5000);
    }
    @Override
    public String getWeather() {
        return "Weather forecast for today will by sunny!";
    }

    @Override
    public String refreshData()  {
        return "Weather forecast for today will  be cold!";
    }
}
