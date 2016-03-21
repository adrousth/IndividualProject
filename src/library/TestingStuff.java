package library;

import org.apache.log4j.Logger;

/**
 * Created by Student on 3/15/2016.
 */
public class TestingStuff {

    public static void main(String[] args) {
        TestingStuff stuff = new TestingStuff();
        stuff.run();
    }

    private void run() {
        Logger log = Logger.getLogger(this.getClass());
        log.info("hello");
    }

}
