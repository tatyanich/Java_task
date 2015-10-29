package com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane;

import java.io.Serializable;

/**
 * Created by Tetiana_Matiunina on 21.10.2015.
 */
public  class Airplane implements Serializable {

    private String airplaneName;
    private static double liftingCapacity;
    private transient double flightDistance;
    private int seatingCapacity;

    public Airplane(String airplaneName, double liftingCapacity, double flightDistance, int seatingCapacity) {
        this.airplaneName = airplaneName;
        this.liftingCapacity = liftingCapacity;
        this.flightDistance = flightDistance;
        this.seatingCapacity = seatingCapacity;
    }

    public String getName() {
        return airplaneName;
    }

    public double getFlightDistance() {
        return flightDistance;
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "airplaneName=' " + airplaneName + '\'' +
                ", flightDistance= " + flightDistance +
                ", seatingCapacity= " + seatingCapacity +
                ", liftingCapacity= " + liftingCapacity+
                '}';
    }
}


