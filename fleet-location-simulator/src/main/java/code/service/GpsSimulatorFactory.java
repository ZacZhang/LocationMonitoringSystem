package code.service;

import code.model.GpsSimulatorRequest;
import code.model.Point;
import code.task.GpsSimulator;

import java.io.File;
import java.util.List;

public interface GpsSimulatorFactory {

    GpsSimulator prepareGpsSimulator(GpsSimulatorRequest gpsSimulatorRequest);

    GpsSimulator prepareGpsSimulator(GpsSimulator gpsSimulator, File kmlFile);

    GpsSimulator prepareGpsSimulator(GpsSimulator gpsSimulator, List<Point> points);

}