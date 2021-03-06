package com.designpatterns.observerpattern;

/**
 * @Author: Meeravali Shaik
 * Date: 7/15/22
 */
public class WeatherConditions implements ObserverTemp,Display{

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public WeatherConditions(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void observe(float temp, float humidity,float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
