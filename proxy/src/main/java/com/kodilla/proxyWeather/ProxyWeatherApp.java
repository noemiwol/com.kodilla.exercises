package com.kodilla.proxyWeather;

import com.kodilla.proxyWeather.db.DbWeatherDataRetriever;
import com.kodilla.proxyWeather.domain.LazyWeatherDataRetrieverProxy;

import java.util.Random;

public class ProxyWeatherApp {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();

        for (int n = 0; n < 5; n++) {
            DbWeatherDataRetriever weatherDataRetriever = new LazyWeatherDataRetrieverProxy();
            int number = new Random().nextInt(100);
            if (number < 20) {
                System.out.println(weatherDataRetriever.refreshData());
            } else if (number < 30) {
                System.out.println(weatherDataRetriever.getWeather());
            }
            System.out.println("Execution #" + n + " just finished");
        }

        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }
}
