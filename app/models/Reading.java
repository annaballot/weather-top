package models;

import javax.persistence.Entity;

import play.Logger;
import play.db.jpa.Model;
import utilities.Conversions;
import utilities.DateTime;


@Entity
public class Reading extends Model
{
    public String date;
    public int code;
    public double temperature;
    public double windSpeed;
    public int pressure;
    public int windDirection;


    public Reading(int code, double temperature, double windSpeed, int pressure, int windDirection) {
        String date = DateTime.getDateTime();
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }



    //getters
    public int getCode() {
        return code;
    }

    public double getTemperature(){
        return temperature;
    }

    public double getWindSpeed(){
        return windSpeed;
    }

    public int getPressure(){
        return pressure;
    }

    public int getWindDirection(){
        return windDirection;
    }

    public String getWindDirectionText(){

        return Conversions.convertWindDirection(windDirection);
    }

    public double getTemperatureFahrenheit(){
        return Conversions.convertTempToFahrenheit(temperature);
    }

    public String getWeatherDescription(){

        return Conversions.convertWeatherCodes(code);
    }

    public String getBeaufort() {

        return Conversions.convertBeaufort(windSpeed) + " bft";
    }

    public double getWindChill() {
        return Conversions.calculateWindChill(temperature, windSpeed);
    }



}