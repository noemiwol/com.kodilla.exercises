package com.kodilla.proxyWeather.db;

public class LazyWeatherDataRetrieverProxy implements DbWeatherDataRetriever {
    private DbWeatherDataRetriever retriever;


    @Override
    public String getWeather() throws InterruptedException {
        if(retriever == null)
            retriever = new WeatherDataRetriever();
        return retriever.getWeather();
    }

    @Override
    public String refreshData() throws InterruptedException {
        if(retriever == null)
            retriever = new WeatherDataRetriever();
        return retriever.refreshData();
    }
}

