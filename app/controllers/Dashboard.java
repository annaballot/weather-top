package controllers;

import java.util.List;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;
import util.StationAnalytics;

public class Dashboard extends Controller {
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = StationCtrl.sortStations(member.stations);
    for (Station station : stations) {
      StationAnalytics.calculateStationFields(station);
    }
    render("dashboard.html", stations);
  }

  public static void addStation(String name, double latitude, double longitude) {

    Logger.info("Adding a new station called " + name);
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, latitude, longitude);
    member.stations.add(station);
    member.save();
    redirect("/dashboard");
  }

  public static void deleteStation(Long id) {
    Station station = Station.findById(id);
    Logger.info("Removing" + station.name);
    Member member = Accounts.getLoggedInMember();
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect("/dashboard");
  }

}

