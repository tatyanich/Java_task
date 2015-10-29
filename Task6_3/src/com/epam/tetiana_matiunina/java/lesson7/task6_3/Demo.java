package com.epam.tetiana_matiunina.java.lesson7.task6_3;




import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.Airplane;
import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.models.Boeing;
import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.models.IL;
import com.epam.tetiana_matiunina.java.lesson7.task6_3.company.AirCompany;

import java.util.ArrayList;

/**
 * Created by Tetiana_Matiunina on 20.10.2015.
 */
public class Demo {
    public static void main(String[] args) {

        AirCompany britishAirlines = new AirCompany("British airlines");
        AirCompany turkishAirlines = new AirCompany("Turkish airlines");

        ArrayList<Airplane> airplanesBritish = new ArrayList<Airplane>();
        Boeing boeing474 = new Boeing("Boeing474", 9.0, 5.0, 240);
        boeing474.hireSteward(7);
        airplanesBritish.add(boeing474);
        airplanesBritish.add(new Boeing("Boeing472", 6.0, 4.0, 130));
        airplanesBritish.add(new Boeing("Boeing174", 2.7, 9.3, 100));
        airplanesBritish.add(new IL("IL44", 6.4, 1.3, 8));
        britishAirlines.addAirplanes(airplanesBritish);

        ArrayList<Airplane> airplanesTurkish = new ArrayList<Airplane>();
        IL il90 = new IL("IL90", 30.4, 10.3, 9);
        il90.setGuns(90);
        airplanesTurkish.add(new Boeing("Boeing787", 100.0, 8.0, 280));
        airplanesTurkish.add(new Boeing("Boeing747-8", 90.0, 88.0, 300));
        airplanesTurkish.add(new Boeing("Boeing737", 10.7, 6.3, 180));
        airplanesTurkish.add(il90);

        turkishAirlines.addAirplanes(airplanesTurkish);
        System.out.println(britishAirlines.getName());

        double totalLiftingCapacity = britishAirlines.calculateTotalCapacity();
        System.out.println("Total lifting capacity of planes: " + totalLiftingCapacity + " ton");

        double totalSeatingCapacity = britishAirlines.calculateTotalSeatingCapacity();
        System.out.println("Total seating capacity:: " + totalSeatingCapacity + " passenger");

        System.out.println("All planes of company:");
        for (Airplane plane : britishAirlines.getAirplanes()) {
            System.out.println(plane.toString());
        }

        britishAirlines.sortPlaneByFlightDistance();
        System.out.println("Sorted plane by distance:");
        for (Airplane plane : britishAirlines.getAirplanes()) {
            System.out.println(plane.toString());
        }
        System.out.println("______________________________________________________________");
        System.out.println(turkishAirlines.getName());

        double totalLiftingCapacity1 = turkishAirlines.calculateTotalCapacity();
        System.out.println("Total lifting capacity of planes: " + totalLiftingCapacity1 + " ton");

        double totalSeatingCapacity1 = turkishAirlines.calculateTotalSeatingCapacity();
        System.out.println("Total seating capacity: " + totalSeatingCapacity1 + " passenger");

        System.out.println();
        for (Airplane plane : turkishAirlines.findAirplanesBySeatingCapacityInRange(4, 150)) {
            System.out.println(plane.toString());
        }

        System.out.println("______________________________________________________________");
        System.out.println(britishAirlines.getName());
        System.out.println(britishAirlines.checkStewards());
        System.out.println(britishAirlines.checkWeapons());

        System.out.println(turkishAirlines.getName());
        System.out.println(turkishAirlines.checkWeapons());
    }


}
