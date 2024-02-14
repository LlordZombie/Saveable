package Media;

import java.util.Arrays;

public class DVD extends MediumNurLesbar {

    public DVD(byte[] daten) {
        super(Arrays.copyOf(daten, 8500), (double) 1 / 500);
    }

}
