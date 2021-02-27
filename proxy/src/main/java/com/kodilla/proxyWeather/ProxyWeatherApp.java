package com.kodilla.proxyWeather;

import com.kodilla.proxyWeather.db.DbWeatherDataRetriever;
import com.kodilla.proxyWeather.db.LazyWeatherDataRetrieverProxy;

import java.util.Random;

public class ProxyWeatherApp {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();

        for (int n = 0; n < 5; n++) {
            DbWeatherDataRetriever dbWeatherDataRetriever = new LazyWeatherDataRetrieverProxy();
            int number = new Random().nextInt(100);
            if (number < 20) {
                System.out.println(dbWeatherDataRetriever.refreshData());
            } else if (number < 30) {
                System.out.println(dbWeatherDataRetriever.getWeather());
            }
            System.out.println("Execution #" + n + " just finished");
        }

        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }
}
