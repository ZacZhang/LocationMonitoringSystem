package service;

import model.GpsSimulatorRequest;
import model.Point;
import task.GpsSimulator;

import java.io.File;
import java.util.List;

public interface GpsSimulatorFactory {

    GpsSimulator prepareGpsSimulator(GpsSimulatorRequest gpsSimulatorRequest);

    GpsSimulator prepareGpsSimulator(GpsSimulator gpsSimulator, File kmlFile);

    GpsSimulator prepareGpsSimulator(GpsSimulator gpsSimulator, List<Point> points);

}