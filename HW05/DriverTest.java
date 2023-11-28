public class DriverTest {
    public static void main(String[] args) {
        VideoGame vg1 = new VideoGame(Genre.ACTION, "1", 5, 12.5, 4, true);
        VideoGame vg2 = new VideoGame(Genre.COMEDY, "3", 4, 12.5, 4, true);
        VideoGame vg3 = new VideoGame(Genre.COMEDY, "3", 4, 12.5, 4, true);

        Movie m1 = new Movie(Genre.ACTION, "2", 10, 3.14, 200);
        Movie m2 = new Movie(Genre.HORROR, "4", 10, 3.14, 200);
        Movie m3 = new Movie(Genre.HORROR, "4", 6);
        Movie test = new Movie(Genre.SCI_FI, "TEST", 90);


        Blockbuster store = new Blockbuster();
        store.addMedia(vg1);
        store.addMedia(vg2);
        store.addMedia(vg3);
        store.addMedia(test);
        store.addMedia(m1);
        store.addMedia(m2);
        store.addMedia(m3);

        store.removeMedia(test);

        store.sortMedia();

        System.out.println(store.findMedia(vg1));

        System.out.println(store.getMostPopularMovie());


    }
}
