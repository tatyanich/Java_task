package com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane;

/**
 * Created by Tetiana_Matiunina on 20.10.2015.
 */
public abstract class MilitaryAirplane extends Airplane {

    protected int guns;

    public MilitaryAirplane(String airplaneName, double liftingCapacity, double flightDistance, int seatingCapacity) {
        super(airplaneName, liftingCapacity, flightDistance, seatingCapacity);
    }

    public void setGuns(int guns) {
        this.guns = guns;
    }

    public int getGuns() {
        return this.guns;
    }

    /**
     * check plane for weapons
     *
     * @return true if plane has weapons, false if not
     */
    public boolean hasWeapons() {
        return (this.getGuns() > 0) ? true : false;
    }

    @Override
    public String toString() {
        return "Plane name: " + getName() + " seating capacity: " + getSeatingCapacity() + " distance: " + getFlightDistance() + " lifting capacity: " + getLiftingCapacity()
                + " number of weapons: " + getGuns();
    }
}
