/**
 * Class that extends Ride representing a RollerCoaster ride.
 * @author Hyeokjin Jin
 * @version CS1331 HW03
 */
public class RollerCoaster extends Ride {

    private double rate;
    private double photoFees;
    private int maxNumRuns;

    /**
     * Helper method that count the number of empty seats on the ride.
     * @return Integer representing the number of empty seats on the ride
     */
    public int emptySeatCount() {
        int count = 0;
        for (String passenger : passengers) {
            if (passenger == null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Constructor method for RollerCoaster objects.
     * @param id String representing identifier of the ride
     * @param runsSinceInspection Integer representing the number of runs the ride has done since most recent inspection
     * @param passengers String array containing names of passengers on the ride
     * @param rate Cost of one run
     * @param photoFees One time fee for the mandatory photo package
     * @param maxNumRuns The maximum number of runs the ride can do before required inspection
     */
    public RollerCoaster(String id, int runsSinceInspection, String[] passengers,
                         double rate, double photoFees, int maxNumRuns) {
        super(id, runsSinceInspection, passengers);
        this.rate = rate;
        this.photoFees = photoFees;
        this.maxNumRuns = maxNumRuns;
    }

    /**
     * Constructor method for RollerCoaster object with id, runsSinceInspection, and maxNumRuns as arguments.
     * @param id String representing identifier of the ride
     * @param runsSinceInspection Integer representing the number of runs the ride has done since most recent inspection
     * @param maxNumRuns The maximum number of runs the ride can do before required inspection
     */
    public RollerCoaster(String id, int runsSinceInspection, int maxNumRuns) {
        this(id, runsSinceInspection, new String[4], 10.0, 15.0, maxNumRuns);
    }

    /**
     * Constructor method for RollerCoaster object with id as argument.
     * @param id String representing identifier of the ride
     */
    public RollerCoaster(String id) {
        this(id, 0, 200);
    }

    @Override
    public boolean canRun(int numberOfRuns) {
        if (numberOfRuns < 0) {
            return false;
        }
        return ((runsSinceInspection + numberOfRuns) <= maxNumRuns);
    }

    @Override
    public boolean inspectRide(String[] components) { //Need to fix
        boolean brakes = false;
        boolean tracks = false;
        for (String component : components) {
            if (component == null) {
                continue;
            }
            if (component.equalsIgnoreCase("Brakes OK")) {
                brakes = true;
            }
            if (component.equalsIgnoreCase("Tracks Clear")) {
                tracks = true;
            }
        }
        if (brakes && tracks) {
            runsSinceInspection = 0;
        }
        return (brakes && tracks);
    }

    @Override
    public double costPerPassenger(int stops) {
        return stops * rate + photoFees;
    }

    @Override
    public boolean addPassengers(int stops, String[] passengers) {
        if (!canRun(stops) || emptySeatCount() < passengers.length) {
            return false;
        }
        for (String passenger : passengers) {
            for (int i = 0; i < this.passengers.length; i++) {
                if (this.passengers[i] == null) {
                    this.passengers[i] = passenger;
                    break;
                }
            }
            chargePassenger(stops);
        }
        runsSinceInspection += stops;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || (!getClass().equals(o.getClass()))) {
            return false;
        }
        RollerCoaster other = (RollerCoaster) o;
        return (super.equals(other) && rate == other.rate
                && photoFees == other.photoFees && maxNumRuns == other.maxNumRuns);
    }

    @Override
    public String toString() {
        return String.format("Roller Coaster %s It can only run %d more times. "
                        + "It costs $%.2f per ride and there is a one-time photo fee of $%.2f.",
                super.toString(), maxNumRuns - runsSinceInspection, rate, photoFees);
    }
}
