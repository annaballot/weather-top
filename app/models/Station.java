package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

import utilities.Conversions;
import utilities.StationAnalytics;

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
            Reading blankReading = new Reading(0, 0, 0, 0, 0);
            return blankReading;
        }
    }

    public double getLongitude()
    {
        return longitude;
    }


}
