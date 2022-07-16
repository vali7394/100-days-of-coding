package com.designpatterns.observerpattern;

/**
 * @Author: Meeravali Shaik
 * Date: 7/15/22
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        WeatherConditions currentDisplay =
                new WeatherConditions(weatherData);
       /* StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);*/
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
        currentDisplay.display();
    }
}
