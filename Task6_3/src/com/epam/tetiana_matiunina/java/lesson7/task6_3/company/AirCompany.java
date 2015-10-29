package com.epam.tetiana_matiunina.java.lesson7.task6_3.company;


import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.Airplane;
import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.CivilianAirplane;
import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.FlightDistanceComparator;
import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.MilitaryAirplane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tetiana_Matiunina on 21.10.2015.
 */
public class AirCompany {
    private String companyName;

    private List<Airplane> airplanesList = new ArrayList<Airplane>();

    public AirCompany(String companyName) {
        this.companyName = companyName;
    }

    /**
     *add all planes list to airplanesList of company
     * @param planes list of planes
     * @return list of planes of the company
     */
    public List<Airplane> addAirplanes(List<Airplane> planes) {
        airplanesList.addAll(planes);
        return airplanesList;
    }

    public String getName() {
        return companyName;
    }

    /**
     *
     * @return list of planes of the company
     */
    public List<Airplane> getAirplanes() {
        return airplanesList;
    }

    /**
     *summarizes the total lifting capacity of the company airplanes
     * @return total lifting capacity of planes in the company
     */
    public double calculateTotalCapacity() {
        double totalCapacity = 0.0;
        for (Airplane plane : airplanesList) {
            totalCapacity += plane.getLiftingCapacity();
        }
        return totalCapacity;
    }
    /**
     *summarizes the total seating capacity of the company airplanes
     * @return total seating capacity of planes in the company
     */
    public double calculateTotalSeatingCapacity() {
        double totalSeatingCapacity = 0.0;
        for (Airplane plane : airplanesList) {
            totalSeatingCapacity += plane.getSeatingCapacity();
        }
        return totalSeatingCapacity;
    }

    /**
     * finds airplanes in the company in given range
     * @param min the minimum limit of the range
     * @param max the maximum limit of the range
     * @return list of airplanes
     */
    public List<Airplane> findAirplanesBySeatingCapacityInRange(int min, int max) {
        List<Airplane> airplanes = new ArrayList<Airplane>();
        for (Airplane airplane : airplanesList) {
            if ((airplane.getSeatingCapacity() >= min) && (airplane.getSeatingCapacity() <= max)) {
                airplanes.add(airplane);
            }
        }
        return airplanes;
    }

    /**
     * sorts list of airplanes by flight distance
     */
    public void sortPlaneByFlightDistance() {
        Collections.sort(airplanesList, new FlightDistanceComparator());
    }

    /**
     * check military airplanes in the company for weapons
     * @return status messages of airplanes armament
     */
    public String checkWeapons() {
        String noWeapons = "";
        for (Airplane airplane : airplanesList) {
            if (airplane instanceof MilitaryAirplane) {
                if (!((MilitaryAirplane) airplane).hasWeapons()) {
                    noWeapons += " There is no weapons on " + airplane.getName() + "\n";
                }
            }
        }
        if (noWeapons.isEmpty()) {
            return "All military plane of: " + getName() + " are armed";
        } else {
            return noWeapons;

        }

    }
    /**
     * check civilian airplanes in the company for stewards
     * @return messages of a flight attendants on planes
     */
    public String checkStewards() {
        String noSteward = "";
        for (Airplane airplane : airplanesList) {
            if (airplane instanceof CivilianAirplane) {
                if (!((CivilianAirplane) airplane).hasSteward()) {
                    noSteward += " There is no steward on " + airplane.getName() + "\n";
                }
            }
        }
        if (noSteward.isEmpty()) {
            return "All civilian plane of: " + getName() + " has stewards";
        } else {
            return noSteward;

        }
    }


}
