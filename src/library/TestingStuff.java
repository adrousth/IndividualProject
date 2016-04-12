package library;

import org.apache.log4j.Logger;

/**
 * Created by Student on 3/15/2016.
 */
public class TestingStuff {

    public static void main(String[] args) {
        TestingStuff stuff = new TestingStuff();
        for (int i = 0; i < 100; i++) {
            int copies = (int) Math.round((6 * Math.random()) + 1);
            System.out.println(copies);
        }
    }

    private void run() {
        Logger log = Logger.getLogger(this.getClass());
        log.info("hello");
    }

}
