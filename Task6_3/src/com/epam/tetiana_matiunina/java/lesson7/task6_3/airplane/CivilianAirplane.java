package com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane;


/**
 * Created by Tetiana_Matiunina on 20.10.2015.
 */
public abstract class CivilianAirplane extends Airplane {

    protected int steward;

    public CivilianAirplane(String airplaneName, double liftingCapacity, double flightDistance, int seatingCapacity) {
        super(airplaneName, liftingCapacity, flightDistance, seatingCapacity);
    }

    public int getSteward() {
        return this.steward;
    }

    public void hireSteward(int steward) {
        this.steward = steward;
    }

    /**
     * check plane for stewards
     *
     * @return true if plane has stewards, false if not
     */
    public boolean hasSteward() {
        return (this.getSteward() > 0) ? true : false;
    }

    @Override
    public String toString() {
        return "Plane name: " + getName() + " seating capacity: " + getSeatingCapacity() + " distance: " + getFlightDistance() + " lifting capacity: " + getLiftingCapacity()
                + " number of stewards: " + getSteward();
    }

}
