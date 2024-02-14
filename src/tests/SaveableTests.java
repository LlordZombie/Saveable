package tests;

import Media.DVD;
import Media.Festplatte;
import Media.UsbStick;

import java.util.Arrays;

public class SaveableTests {
    public static void main(String[] args) {
        DVD d = new DVD(new byte[]{1,23,4,5});
        Festplatte f = new Festplatte(40);
        UsbStick u = new UsbStick(40,10);
        for (int i = 0; i < 100; i++) {
            f.schreiben(i%39,new byte[]{(byte)(i%39)});
            u.schreiben(i%39,new byte[]{(byte)(i%39)});
        }
        System.out.println(d+"\n\n"+u+"\n\n"+f+"\n\n"+Arrays.toString(d.lesen(2,3))+"\n"+Arrays.toString(f.lesen(2,3))+"\n"+Arrays.toString(u.lesen(2,3))+"\n");
        System.out.println();

    }
}
