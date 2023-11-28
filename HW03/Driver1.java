
public class Driver1 {
    public static void main (String[] args){
        //RollerCoaster testing
        RollerCoaster test1 = new RollerCoaster("test1", 3, 10);
        RollerCoaster test2 = new RollerCoaster("test2");
        RollerCoaster test3 = new RollerCoaster("test1", 3, 10);
        System.out.println(test1.equals(test3));
        System.out.println(test3.equals(test1));
        System.out.println(test1.equals(test2));
        String[] newPpl = {"Sally", "Joe", "Lucy", "Jimmy"};
        System.out.println(test1.toString());
        System.out.println(test1.getPassengerList());
        test1.addPassengers(5, newPpl);
        System.out.println(test1.toString());
        System.out.println(test1.getPassengerList());
        System.out.println(test1.canRun(2));
        System.out.println(test1.canRun(12));
        System.out.println(test1.inspectRide(new String[] {"blah blah blah", "Brakes Ok", "null", "ghghghg", null}));
        System.out.println(test1.inspectRide(new String[] {null, "Tracks Clear", "blah blah blah", "Brakes Ok", "null", "ghghghg"}));
        System.out.println(test1.toString());
        System.out.println("YOO");

        //Trolley testing
        Trolley test4 = new Trolley("test4", 0, new String[] {"Station A", "Station B", "Station C"}, 0);
        Trolley test5 = new Trolley("test5", 0, new String[] {"Station 1", "Station 2", "Station 3", "Station 4"}, 2);
        Trolley test6 = new Trolley("test4", 0, new String[] {"Station A", "Station B", "Station C"}, 0);
        System.out.println(test4.equals(test6)); //true
        System.out.println(test5.equals(test6)); //false
        System.out.println(test6.equals(test4)); //true
        System.out.println(test4.canRun(15)); //true
        System.out.println(test5.canRun(-8)); //false
        System.out.println(test4.inspectRide(new String[] {"blah blah blah", "Brakes Ok", null, "ghghghg"})); //false
        System.out.println(test4.inspectRide(new String[] {"Gas Tank Not Empty", "Brakes Ok", null, "ghghghg"})); //true
        System.out.println(test5.costPerPassenger(5));
        System.out.println();
        test4.addPassengers(7, newPpl);
        System.out.println(test4.toString());
        System.out.println(test4.getPassengerList());
        test4.addPassengers(7, newPpl);
        System.out.println(test4.toString());
        System.out.println(test4.getPassengerList());
        test4.removePassenger("Sally");
        System.out.println(test4.getPassengerList());
        System.out.println(test5.toString());
        test5.moveTrolley(5);
        System.out.println(test5.toString());
       }
}
