package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import util.DateTime;
import util.StationAnalytics;

import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class StationCtrl extends Controller {
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + id);
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

  public static void addReading(Long id, int code, double temperature, double windSpeed, int pressure, int windDirection) {
    Date date = DateTime.getDateTime();
    Reading reading = new Reading(date, code, temperature, windSpeed, pressure, windDirection);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect("/stations/" + id);
  }

  public static void deleteReading(Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info("Removing " + readingid);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    render("station.html", station);
  }

  public static List<Station> sortStations(List<Station> station) {
    station.sort(Comparator.comparing(Station::getName, String.CASE_INSENSITIVE_ORDER));
    Logger.info("Sorting Stations Alphabetically by Name");
    return station;
  }

}
