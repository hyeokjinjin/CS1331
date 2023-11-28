/**
 * Driver class.
 * @author Hyeokjin Jin
 * @version HW02 10/11/23
 */
public class Aquarium {
    /**
     * Main method.
     * @param args Command line arguments not used.
     */
    public static void main(String[] args) {
        //Fish object with empty parameters
        Fish emptyFish = new Fish();
        System.out.println(emptyFish);
        System.out.println();

        //Fish objects that should all have name "Nemo"
        Fish nameTest1 = new Fish(null, 25.015, 16.015);
        Fish nameTest2 = new Fish("", 5.0, 16.68);
        Fish nameTest3 = new Fish("     ", 5.0, 12.0);
        System.out.println(nameTest1);
        System.out.println(nameTest2);
        System.out.println(nameTest3);
        System.out.println();

        //Fish objects with length 8.0
        Fish lengthTest1 = new Fish("lengthTest1", null, 12.0);
        Fish lengthTest2 = new Fish("lengthTest2", (10.0 / 0.0), 12.0);
        Fish lengthTest3 = new Fish("lengthTest3", Double.POSITIVE_INFINITY, 12.0);
        Fish lengthTest4 = new Fish("lengthTest4", -2.0, 12.0);
        System.out.println(lengthTest1);
        System.out.println(lengthTest2);
        System.out.println(lengthTest3);
        System.out.println(lengthTest4);
        System.out.println();

        //Fish objects with length 8.0
        Fish weightTest1 = new Fish("weightTest1", 124.0, null);
        Fish weightTest2 = new Fish("weightTest2", 52.12345, Double.POSITIVE_INFINITY / 0.0);
        Fish weightTest3 = new Fish("weightTest3", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Fish weightTest4 = new Fish("weightTest4", 50.0, -12.0);
        System.out.println(weightTest1);
        System.out.println(weightTest2);
        System.out.println(weightTest3);
        System.out.println(weightTest4);
        System.out.println();

        //Fish DeepCopy
        Fish original = new Fish("Original", 25.0123, 111.0);
        Fish copy = new Fish(original);
        //original.setLength(2.0);
        System.out.println(original);
        System.out.println(copy);
        System.out.println();

        //Catfish Empty Constructor
        Catfish emptyCatfish = new Catfish();
        System.out.println(emptyCatfish);
        System.out.println();

        //Catfish default parameter
        Catfish catfishDefault = new Catfish("Default Catfish", 137.21, 917.0, 12.0);
        Catfish whiskerTest1 = new Catfish("test1", 1.1, 12395.73, null);
        Catfish whiskerTest2 = new Catfish("test2", 97.0, 912.18, 100.0 / 0.0);
        Catfish whiskerTest3 = new Catfish("test3", 8.51, 101.123, -123.0);
        Catfish whiskerTest4 = new Catfish("test4", 7.123, 12.3956, Double.POSITIVE_INFINITY);
        System.out.println(catfishDefault);
        System.out.println(whiskerTest1);
        System.out.println(whiskerTest2);
        System.out.println(whiskerTest3);
        System.out.println(whiskerTest4);
        System.out.println();

        //Deep copy Catfish and setter
        Catfish originalCatfish = new Catfish();
        Catfish copyCatfish = new Catfish(originalCatfish);
        originalCatfish.setWhiskerLength(10000.0);
        System.out.println(originalCatfish);
        System.out.println(copyCatfish);
        System.out.println();

        //StripedBass Empty Constructor
        StripedBass emptyStripedBass = new StripedBass();
        System.out.println(emptyStripedBass);
        System.out.println();

        //StripedBass Default Constructor
        StripedBass bassTest1 = new StripedBass("Test1", -1.0, -1.0, -5, true, null);
        System.out.println(bassTest1);
        bassTest1.migrate();
        System.out.println(bassTest1);
        StripedBass bassTest2 = new StripedBass("Test2", 123.0, 123.0, 123, false, catfishDefault);
        System.out.println(bassTest2);
        bassTest2.migrate();
        System.out.println(bassTest2);
        System.out.println();

        //Deep copy StripedBass
        StripedBass bassOriginal = new StripedBass();
        StripedBass bassCopy = new StripedBass(bassOriginal);
        bassOriginal.migrate();
        System.out.println(bassOriginal);
        System.out.println(bassCopy);
        System.out.println();

        //FlyingFish Empty Constructor
        FlyingFish emptyFlying = new FlyingFish();
        System.out.println(emptyFlying);
        emptyFlying.fly();

        System.out.println();

        //FlyingFish Default Constructor
        FlyingFish defaultFish = new FlyingFish("defaultFish", 1.0, 1.0, 5);
        FlyingFish copyFish = new FlyingFish(defaultFish);
        defaultFish.fly();
        copyFish.fly();
        System.out.println(defaultFish);
        System.out.println(copyFish);

    }
}
