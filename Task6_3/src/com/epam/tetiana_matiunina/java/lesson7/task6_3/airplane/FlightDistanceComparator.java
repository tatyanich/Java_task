package com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane;

import java.util.Comparator;

/**
 * Created by Tetiana_Matiunina on 22.10.2015.
 */
public class FlightDistanceComparator implements Comparator<Airplane> {

    /**
     * compares two airplane
     *
     * @param o1 plane of the company
     * @param o2 plane of the company
     * @return 0 if flight distance is the same, negative int if flight distance of o2 bigger then o1,
     * positive int if flight distance of o1 bigger then o2
     */
    @Override
    public int compare(Airplane o1, Airplane o2) {
        return (int) (o1.getFlightDistance() - o2.getFlightDistance());
    }
}
