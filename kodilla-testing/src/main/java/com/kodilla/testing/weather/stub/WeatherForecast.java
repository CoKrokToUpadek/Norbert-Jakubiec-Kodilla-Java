package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }


    public double averageTemperature(){
        double averageTemp=0;
        int numOfRecords=0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
              averageTemp+= temperature.getValue();
              numOfRecords++;
        }
        if (numOfRecords==0){
            return 404;
        }else {
            return averageTemp/numOfRecords;
        }
    }

    public double medianTemperature(){
        List<Double> temp=new ArrayList<>();


        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            temp.add(temperature.getValue());
        }
        Collections.sort(temp);

        if (temp.size()==0){
            return 404;
        }

        if (temp.size()%2!=0){
            return temp.get((temp.size()/2));
        }else {
            return (double)Math.round(temp.get(((temp.size()/(2)+temp.size()/2)-1)/2)*100)/100;
        }

    }

}
