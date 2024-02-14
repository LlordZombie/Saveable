package Media;

import java.util.Arrays;

/**
 * DVD class represents a DVD medium.
 * It extends the MediumNurLesbar class.
 */
public class DVD extends MediumNurLesbar {

    /**
     * Constructor for creating a DVD object with given data.
     * @param daten The data to be copied into the DVD object.
     */
    public DVD(byte[] daten) {
        super(Arrays.copyOf(daten, 8500), (double) 1 / 500);
    }

}
