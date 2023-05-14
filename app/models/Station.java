package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
import util.StationAnalytics;

import java.util.Date;

@Entity
public class Station extends Model
{
    public String name;
    public double latitude;
    public double longitude;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();
    public double windSpeed;
    public double maxTemperature;
    public double minTemperature;
    public double maxWindSpeed;
    public double minWindSpeed;
    public int maxPressure;
    public int minPressure;
    public String tempTrend;
    public String windSpeedTrend;
    public String pressureTrend;

    public Station(String name, double latitude, double longitude)
    {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Reading getLatestReading()
    {
        if (readings.size()>0) {
            return readings.get(readings.size() - 1);
        }
        else {
            Date date = new Date();
            Reading blankReading = new Reading(date, 0, 0, 0, 0, 0);
            return blankReading;
        }
    }

//    public List<Reading> getLatestReading

    public Reading get2ndLatestReading()
    {
        if (readings.size()>1) {
            return readings.get(readings.size() - 2);
        }
        else {
            Date date = new Date();
            Reading blankReading = new Reading(date, 0, 0, 0, 0, 0);
            return blankReading;
        }
    }

    public Reading get3rdLatestReading()
    {
        if (readings.size()>2) {
            return readings.get(readings.size() - 3);
        }
        else {
            Date date = new Date();
            Reading blankReading = new Reading(date, 0, 0, 0, 0, 0);
            return blankReading;
        }
    }

    public double getLongitude()
    {
        return longitude;
    }

    public String getName() {
        return name;
    }

//    public double getMaxTemperature()
//    {
//            return StationAnalytics.getMaxTemperature(readings);
//
//    }



}
