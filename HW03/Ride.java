/**
 * Abstract class for ride tracking system at Six Flags.
 * @author Hyeokjin Jin
 * @version CS1331 HW03
 */
public abstract class Ride {

    protected final String id;
    protected double earnings = 0;
    protected int runsSinceInspection;
    protected String[] passengers;

    /**
     * Constructor with id, runsSinceInspection, and passengers as arguments.
     * @param id String identifier of the ride
     * @param runsSinceInspection Integer representing the number of runs the ride has completed since last inspection
     * @param passengers String array with names of passengers aboard the ride
     */
    public Ride(String id, int runsSinceInspection, String[] passengers) {
        this.id = id;
        this.runsSinceInspection = runsSinceInspection;
        this.passengers = new String[passengers.length]; //Deep Copying Passengers
        for (int i = 0; i < passengers.length; i++) {
            this.passengers[i] = passengers[i];
        }
    }

    /**
     * Ride constructor with only id and passengers as arguments.
     * @param id String identifier of the ride
     * @param passengers String array with names of passengers aboard the ride
     */
    public Ride(String id, String[] passengers) {
        this(id, 0, passengers);
    }

    /**
     * Method that calculates if ride can complete the inputted number of runs without needing an inspection.
     * @param numberOfRuns Integer representing the number of runs that the ride will do
     * @return Boolean representing whether the ride can complete the inputted runs without an inspection
     */
    public abstract boolean canRun(int numberOfRuns);

    /**
     * Method that performs an inspection of the ride.
     * @param components String array representing the different components of the ride
     * @return Boolean representing whether the ride passes the inspection
     */
    public abstract boolean inspectRide(String[] components);

    /**
     * Method that computes the cost of the ride for the specified number of stops.
     * @param stops The number of stops that the cost will be computed for
     * @return Integer representing the cost of the ride for specified number of stops
     */
    public abstract double costPerPassenger(int stops);

    /**
     * Method that adds passengers to the ride.
     * @param stops Integer representing the number of stops
     * @param addedPassengers String array that contains the passenger names
     * @return Boolean representing if all new passengers can fit on the ride
     */
    public abstract boolean addPassengers(int stops, String[] addedPassengers);

    /**
     * Method that gets the list of passengers on the ride.
     * @return String containing the id and the passenger list
     */
    public String getPassengerList() {
        String output = "";
        for (String passenger : passengers) {
            if (passenger != null) {
                output += passenger + "\n";
            }
        }
        return String.format("Passenger List for %s:%n%s", id, output).trim();
    }

    /**
     * Method that updates the earning after charging a passenger for the specified number of stops.
     * @param stops Integer representing the number of stops
     */
    public final void chargePassenger(int stops) {
        earnings += costPerPassenger(stops);
    }

    /**
     * Method that removes passenger from ride.
     * @param name String that represent name of passenger that is to be removed
     * @return Boolean representing whether the passenger that is to be removed is in the ride
     */
    public boolean removePassenger(String name) {
        for (int i = 0; i < passengers.length; i++) {
            if (name.equalsIgnoreCase(passengers[i])) {
                passengers[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || (!getClass().equals(o.getClass()))) {
            return false;
        }
        Ride other = (Ride) o;
        return (id == null ? other.id == null : id.equals(other.id)
                && runsSinceInspection == other.runsSinceInspection);
    }

    @Override
    public String toString() {
        return String.format("%s has run %d times and has earned $%.2f.", id, runsSinceInspection, earnings);
    }
}
