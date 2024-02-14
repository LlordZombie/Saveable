package tests;

import Media.DVD;
import Media.Festplatte;
import Media.UsbStick;

import java.util.Arrays;

/**
 * The SaveableTests class contains a main method to test the functionalities
 * of DVD, Festplatte, and UsbStick classes.
 */
public class SaveableTests {

    /**
     * The main method for testing.
     * Creates instances of DVD, Festplatte, and UsbStick, writes data to them,
     * reads data from them, and prints the results.
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a DVD with initial data
        DVD d = new DVD(new byte[]{1,23,4,5});
        // Create a Festplatte with capacity 40 bytes
        Festplatte f = new Festplatte(40);
        // Create a UsbStick with capacity 40 bytes and block size 10
        UsbStick u = new UsbStick(40,10);

        // Write data to Festplatte and UsbStick in a loop
        for (int i = 0; i < 100; i++) {
            f.schreiben(i % 39, new byte[]{(byte)(i % 39)});
            u.schreiben(i % 39, new byte[]{(byte)(i % 39)});
        }

        // Print the content of DVD, Festplatte, and UsbStick,
        // and read data from them and print the results
        System.out.println(d + "\n\n" + u + "\n\n" + f + "\n\n" +
                Arrays.toString(d.lesen(2, 3)) + "\n" +
                Arrays.toString(f.lesen(2, 3)) + "\n" +
                Arrays.toString(u.lesen(2, 3)) + "\n");
        System.out.println();
    }
}
