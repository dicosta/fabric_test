package diego.com.fabrictest;

/**
 * Created by diego on 03/06/16.
 */

public class HelperClass {

    public static void crashWithNPE() {
        String name = null;
        String crash = name.toString();
    }
}
