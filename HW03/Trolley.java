/**
 * Class that extends Ride representing a Trolley ride.
 * @author Hyeokjin Jin
 * @version CS1331 HW03
 */
public class Trolley extends Ride {

    private String[] stations;
    private int currentStation;

    /**
     * Helper method that finds the next Trolley station.
     * @return Index of the next station in the stations array.
     */
    public int nextStation() {
        if ((currentStation + 1) == stations.length) {
            return 0;
        } else {
            return currentStation + 1;
        }
    }

    /**
     * Helper method that determines if the stations array for this Trolley object
     * is equal to another Trolley object's stations array.
     * @param other Trolley object that this Trolley object's stations is compared to
     * @return Boolean representing whether the two stations arrays are equal
     */
    public boolean stationEqualCheck(Trolley other) {
        for (int i = 0; i < stations.length; i++) {
            if (!stations[i].equalsIgnoreCase(other.stations[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Trolley object constructor method with id, runsSinceInspection, stations, and currentStations as arguments.
     * @param id String representing identifier of the ride
     * @param runsSinceInspection Integer representing the number of runs the ride has done since most recent inspection
     * @param stations String array with the names of the stations
     * @param currentStation Index of the current station that the Trolley is at
     */
    public Trolley(String id, int runsSinceInspection, String[] stations, int currentStation) {
        super(id, runsSinceInspection, new String[20]);

        this.stations = new String[stations.length];
        for (int i = 0; i < stations.length; i++) {
            this.stations[i] = stations[i];
        }

        this.currentStation = currentStation;
    }

    /**
     * Trolley object constructor with id, stations, and currentStations as arguments.
     * @param id String representing identifier of the ride
     * @param stations String array with the names of the stations
     * @param currentStation Index of the current station that the Trolley is at
     */
    public Trolley(String id, String[] stations, int currentStation) {
        this(id, 0, stations, currentStation);
    }

    @Override
    public boolean canRun(int numberOfRuns) {
        return (numberOfRuns >= 0);
    }

    @Override
    public boolean inspectRide(String[] components) { //Need to fix
        boolean brakes = false;
        boolean gas = false;
        for (String component : components) {
            if (component == null) {
                continue;
            }
            if (component.equalsIgnoreCase("Brakes OK")) {
                brakes = true;
            }
            if (component.equalsIgnoreCase("Gas Tank Not Empty")) {
                gas = true;
            }
        }
        if (brakes && gas) {
            runsSinceInspection = 0;
        }
        return (brakes && gas);
    }

    @Override
    public double costPerPassenger(int stops) {
        return (double) (stops * 3) / (stations.length);
    }

    @Override
    public boolean addPassengers(int stops, String[] passengers) {
        if (canRun(stops)) {
            for (String passenger : passengers) {
                for (int i = 0; i < this.passengers.length; i++) {
                    if (this.passengers[i] == null) {
                        this.passengers[i] = passenger;
                        chargePassenger(stops);
                        break;
                    }
                }
            }
            moveTrolley(stops);
            return true;
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
        Trolley other = (Trolley) o;
        return (super.equals(other) && currentStation == other.currentStation && stationEqualCheck(other));
    }

    /**
     * Method that moves the Trolley by the specified number of stops and updates runsSinceInspection for each run done.
     * @param stops Integer representing the specified number of stops the Trolley will do
     */
    public void moveTrolley(int stops) {
        for (int i = 0; i < stops; i++) {
            if ((currentStation + 1) == stations.length) {
                currentStation = 0;
                runsSinceInspection++;
            } else {
                currentStation++;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Trolley %s has driven %d loops and has earned $%.2f. "
                        + "This trolley is at %s. Next up is %s.",
                id, runsSinceInspection, earnings, stations[currentStation], stations[nextStation()]);
    }
}
