package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utilities.StationAnalytics;

public class StationCtrl extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);
        station.maxTemperature = StationAnalytics.getMaxTemperature(station.readings);
        station.minTemperature = StationAnalytics.getMinTemperature(station.readings);
        station.maxWindSpeed = StationAnalytics.getMaxWindSpeed(station.readings);
        station.minWindSpeed = StationAnalytics.getMinWindSpeed(station.readings);
        station.maxPressure = StationAnalytics.getMaxPressure(station.readings);
        station.minPressure = StationAnalytics.getMinPressure(station.readings);
        station.tempTrend = StationAnalytics.getTempTrend(station, station.readings);
        station.windSpeedTrend = StationAnalytics.getWindSpeedTrend(station, station.readings);
        station.pressureTrend = StationAnalytics.getPressureTrend(station, station.readings);
        render("station.html", station);
    }

    public static void addReading(Long id, int code, double temperature, double windSpeed, int pressure, int windDirection)
    {
        Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }

    public static void deleteReading (Long id, Long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info ("Removing " + readingid);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }

}
