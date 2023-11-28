public class Driver {

    public static void main(String[] args) {
        RollerCoaster rcTest1 = new RollerCoaster("rcTest1", 113,
                new String[]{"Person1", "Person2", null, null, "Person3"},
                12.15, 2.75, 160);

        RollerCoaster rcTest2 = new RollerCoaster("rcTest2", 16, 36);

        RollerCoaster rcTest3 = new RollerCoaster("rcTest3");

        RollerCoaster rcTest1copy = new RollerCoaster("rcTest1", 113,
                new String[]{"Bob", null, null, null, "Josh"},
                12.15, 2.75, 160);

        System.out.println("Testing .equals Method");
        System.out.println(rcTest1copy.equals(rcTest1) + " - Should be true");
        System.out.println(rcTest1.equals(rcTest1copy) + " - Should be true");
        System.out.println(rcTest1.equals(rcTest2) + " - Should be false");
        System.out.println(rcTest2.equals(rcTest3) + " - Should be false");
        System.out.println();


        System.out.println("Testing canRun Method");
        System.out.println(rcTest2.canRun(-1) + " - Should be false");
        System.out.println(rcTest2.canRun(0) + " - Should be true");
        System.out.println(rcTest2.canRun(19) + " - Should be true");
        System.out.println(rcTest2.canRun(20) + " - Should be true");
        System.out.println(rcTest2.canRun(21) + " - Should be false");
        System.out.println(rcTest2.canRun(100) + " - Should be false");
        System.out.println();


        System.out.println("Testing inspectRide Method");
        System.out.println(rcTest1);
        System.out.println(rcTest1.canRun(160) + " - Should be false");
        System.out.println(rcTest1.inspectRide(new String[]{"Tracks cLear", "yuh", "yuh", "bak", "braKES ok", "test"}) + " - Should be true");
        System.out.println(rcTest1.canRun(160) + " - Should be true");
        System.out.println(rcTest1);
        System.out.println(rcTest2.inspectRide(new String[]{"BraKES OK", "track clear", "ehw"}) + " - Should be false");
        System.out.println(rcTest2.canRun(36) + " - Should be false");
        System.out.println();


        System.out.println("Testing addPassenger, removePassenger, toString Method");
        System.out.println(rcTest1copy.addPassengers(1, new String[]{"Bob", "Nick", "Troy", "Dalton"}) + " - Should be false");
        System.out.println(rcTest1copy.getPassengerList());
        System.out.println(rcTest1copy);
        System.out.println(rcTest1copy.addPassengers(2, new String[]{"Percy", "Bob", "Troy"}) + " - Should be true");
        System.out.println(rcTest1copy.getPassengerList());
        System.out.println(rcTest1copy);
        System.out.println(rcTest1copy.removePassenger("BOB") + " - Should be true");
        System.out.println(rcTest1copy.getPassengerList());
        System.out.println();

        Trolley tTest1 = new Trolley("tTest1", 23,
                new String[]{"Station 1", "Station 2", "Station 3", "Station 4", "Station 5"},
                2);
        Trolley tTest2 = new Trolley("tTest2", new String[]{"Station A", "Station B", "Station C"},
                2);

        Trolley tTest1copy = new Trolley("tTest1", 23,
                new String[]{"Station 1", "Station 2", "Station 3", "Station 4", "Station 5"},
                2);

        System.out.println("Testing Trolley .equals Method");
        System.out.println(tTest1copy.equals(tTest1) + " - Should be true");
        System.out.println(tTest1.equals(tTest1copy) + " - Should be true");
        System.out.println(tTest2.equals(tTest1) + " - Should be false");
        System.out.println();


        System.out.println("Testing canRun Method");
        System.out.println(tTest2.canRun(-1) + " - Should be false");
        System.out.println(tTest2.canRun(1) + " - Should be true");
        System.out.println(tTest2.canRun(0) + " - Should be true");
        System.out.println();


        System.out.println("Testing inspectRide Method");
        System.out.println(tTest1.inspectRide(new String[]{"GAS", "BRAKES  OK", "YEUAH", null}) + " - Should be false");
        System.out.println(tTest1);
        System.out.println(tTest1.inspectRide(new String[]{"BrAKES ok", "BASUD", "GAS tank NOT empty"}) + " - Should be true");
        System.out.println(tTest1);
        System.out.println();


        System.out.println("Testing addPassenger, removePassenger, toString Method");
        System.out.println(tTest2.getPassengerList());
        System.out.println(tTest2.addPassengers(4, new String[]{"Tony", "Grayson", "Grayson"}) + " - Should be true");
        System.out.println(tTest2.getPassengerList());
        System.out.println(tTest2);
        System.out.println(tTest2.removePassenger("Grayson") + " - Should be true");
        System.out.println(tTest2.removePassenger("Holt") + " - Should be false");
        System.out.println(tTest2.getPassengerList());

        System.out.println(tTest1copy.addPassengers(1,
                new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "BOB"}) + " - Should be true");
        System.out.println(tTest1copy.getPassengerList());
        System.out.println(tTest1copy);
    }


}
