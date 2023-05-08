package utilities;

import models.Reading;

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

}
