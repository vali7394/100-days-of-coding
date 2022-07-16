package com.designpatterns.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Meeravali Shaik
 * Date: 7/15/22
 */
public class WeatherData implements Subject{

    List<ObserverTemp> observerList;
    float temperature;
    float humidity;
    float pressure;

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(ObserverTemp observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(ObserverTemp observer) {
        if(observerList.isEmpty()){
            return;
        }
        int i = observerList.indexOf(observer);
        if(i > 0)
            observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observerList.forEach(observerTemp -> observerTemp.observe(temperature,humidity,pressure));
    }

    public void measurementsChanged() {
        notifyObserver();
    }
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


}
