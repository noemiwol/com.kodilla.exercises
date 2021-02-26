package com.kodilla.proxyWeather.db;

public class LazyWeatherDataRetrieverProxy implements DbWeatherDataRetriever {
    private DbWeatherDataRetriever retriever;

    @Override
    public String getWeather() throws InterruptedException {
        if (retriever == null)
            retriever = new DbWeatherDataRetriever() {
                @Override
                public String getWeather() throws InterruptedException {
                    return null;
                }

                @Override
                public String refreshData() throws InterruptedException {
                    return null;
                }
            };
        return retriever.getWeather();
    }

    @Override
    public String refreshData() throws InterruptedException {
        if (retriever == null)
            retriever = new DbWeatherDataRetriever() {
                @Override
                public String getWeather() throws InterruptedException {
                    return null;
                }

                @Override
                public String refreshData() throws InterruptedException {
                    return null;
                }
            };
        return retriever.refreshData();
    }
}

