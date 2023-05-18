package models;

import javax.persistence.Entity;
import java.util.Date;

import play.db.jpa.Model;
import util.Conversions;


@Entity
public class Reading extends Model {
  public Date date;
  public int code;
  public double temperature;
  public double windSpeed;
  public int pressure;
  public int windDirection;


  public Reading(Date date, int code, double temperature, double windSpeed, int pressure, int windDirection) {
    this.date = date;
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

  public double getTemperature() {
    return temperature;
  }

  public double getWindSpeed() {
    return windSpeed;
  }

  public int getPressure() {
    return pressure;
  }

  public int getWindDirection() {
    return windDirection;
  }

  public String getWindDirectionText() {
    return Conversions.convertWindDirection(windDirection);
  }

  public double getTemperatureFahrenheit() {
    return Conversions.convertTempToFahrenheit(temperature);
  }

  public String getWeatherDescription() {
    return Conversions.convertWeatherCodes(code);
  }

  public String getBeaufort() {
    return Conversions.convertBeaufort(windSpeed) + " bft";
  }

  public double getWindChill() {
    return Conversions.calculateWindChill(temperature, windSpeed);
  }


}