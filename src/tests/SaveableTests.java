package tests;

import Media.DVD;
import Media.Festplatte;
import Media.UsbStick;

public class SaveableTests {
    public static void main(String[] args) {
        DVD d = new DVD(new byte[]{1,23,4,5});
        Festplatte f = new Festplatte(40);
        UsbStick u = new UsbStick(40,10);
    }
}
