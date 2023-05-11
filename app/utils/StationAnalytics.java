package utils;

import models.Reading;
import models.Station;

import java.util.List;

public class StationAnalytics {

    public static double getMaxTemperature(List<Reading> readings)
    {
        Reading maxTempReading = null;
        if (readings.size() > 0) {
            maxTempReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature > maxTempReading.temperature) {
                    maxTempReading = reading;
                }
            }
            return maxTempReading.temperature;
        }
        else {
            return 0;
        }
    }

    public static double getMinTemperature(List<Reading> readings)
    {
        Reading minTempReading = null;
        if (readings.size() > 0) {
            minTempReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature < minTempReading.temperature) {
                    minTempReading = reading;
                }
            }
            return minTempReading.temperature;
        }
        else {
            return 0;
        }

    }

    public static double getMaxWindSpeed(List<Reading> readings)
    {
        Reading maxWindSpeedReading = null;
        if (readings.size() > 0) {
            maxWindSpeedReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed > maxWindSpeedReading.windSpeed) {
                    maxWindSpeedReading = reading;
                }
            }
            return maxWindSpeedReading.windSpeed;
        }
        else {
            return 0;
        }

    }

    public static double getMinWindSpeed(List<Reading> readings)
    {
        Reading minWindSpeedReading = null;
        if (readings.size() > 0) {
            minWindSpeedReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed < minWindSpeedReading.windSpeed) {
                    minWindSpeedReading = reading;
                }
            }
            return minWindSpeedReading.windSpeed;
        }
        else {
            return 0;
        }

    }

    public static int getMaxPressure(List<Reading> readings)
    {
        Reading maxPressureReading = null;
        if (readings.size() > 0) {
            maxPressureReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure > maxPressureReading.pressure) {
                    maxPressureReading = reading;
                }
            }
            return maxPressureReading.pressure;
        }
        else {
            return 0;
        }

    }

    public static int getMinPressure(List<Reading> readings)
    {
        Reading minPressureReading = null;
        if (readings.size() > 0) {
            minPressureReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure < minPressureReading.pressure) {
                    minPressureReading = reading;
                }
            }
            return minPressureReading.pressure;
        }
        else {
            return 0;
        }

    }

    public static String getTempTrend(Station station, List<Reading> readings)
    {
        double temp1 = station.getLatestReading().getTemperature();
        double temp2 = station.get2ndLatestReading().getTemperature();
        double temp3 = station.get3rdLatestReading().getTemperature();

        if (readings.size()<3) {
//            return "Steady";
            return "fa-solid fa-arrow-right-arrow-left";
        }
        else if ((temp1 > temp2) && (temp2 > temp3)) {
//            return "Rising";
            return "fa-solid fa-arrow-up";
        }
        else if ((temp1 < temp2) && (temp2 < temp3)) {
//            return "Falling";
            return "fa-solid fa-arrow-down";
        }
        else {
            return "fa-solid fa-arrow-right-arrow-left";
//            return "Steady";
        }
    }

    public static String getWindSpeedTrend(Station station, List<Reading> readings)
    {
        double windSpeed1 = station.getLatestReading().getWindSpeed();
        double windSpeed2 = station.get2ndLatestReading().getWindSpeed();
        double windSpeed3 = station.get3rdLatestReading().getWindSpeed();

        if (readings.size()<3) {
//            return "Steady";
            return "fa-solid fa-arrow-right-arrow-left";
        }
        else if ((windSpeed1 > windSpeed2) && (windSpeed2 > windSpeed3)) {
//            return "Rising";
            return "fa-solid fa-arrow-up";
        }
        else if ((windSpeed1 < windSpeed2) && (windSpeed2 < windSpeed3)) {
//            return "Falling";
            return "fa-solid fa-arrow-down";
        }
        else {
//            return "Steady";
            return "fa-solid fa-arrow-right-arrow-left";
        }
    }

    public static String getPressureTrend(Station station, List<Reading> readings)
    {
        double pressure1 = station.getLatestReading().getPressure();
        double pressure2 = station.get2ndLatestReading().getPressure();
        double pressure3 = station.get3rdLatestReading().getPressure();

        if (readings.size()<3) {
//            return "Steady";
            return "fa-solid fa-arrow-right-arrow-left";
        }
        else if ((pressure1 > pressure2) && (pressure2 > pressure3)) {
//            Rising
            return "fa-solid fa-arrow-up";
        }
        else if ((pressure1 < pressure2) && (pressure2 < pressure3)) {
//            return "Falling";
            return "fa-solid fa-arrow-down";
        }
        else {
//            return "Steady";
            return "fa-solid fa-arrow-right-arrow-left";
        }
    }

}
