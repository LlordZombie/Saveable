package Media;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Represents a medium that is only readable.
 */
class MediumNurLesbar {
    /** The data stored in the medium. */
    protected byte[] daten;

    /** The probability of a bit error occurring. */
    protected double bitfehlerrate;

    /**
     * Constructs a new MediumNurLesbar with the given data and bit error rate.
     *
     * @param daten the data to be stored in the medium
     * @param bitfehlerrate the probability of a bit error occurring
     */
    protected MediumNurLesbar(byte[] daten, double bitfehlerrate) {
        this.bitfehlerrate = bitfehlerrate;
        this.daten = Arrays.copyOf(daten, daten.length);
    }

    /**
     * Returns the capacity of the medium (number of bytes).
     *
     * @return the capacity of the medium
     */
    public long getKapazitaet() {
        return daten.length;
    }

    /**
     * Reads a specified portion of data from the medium.
     *
     * @param start the starting index from where to read
     * @param lng the length of data to be read
     * @return the read data as byte array
     * @throws IllegalArgumentException if the requested data exceeds the available data
     */
    public byte[] lesen(int start, int lng) {
        if (start + lng > getKapazitaet())
            throw new IllegalArgumentException("There is less Data than you want to read");
        Random random = new Random();
        Byte[] data = IntStream.range(0, daten.length).mapToObj(i -> {
            byte bitFailure = (byte) (daten[i] ^ (1 << random.nextInt(8)));
            return random.nextDouble() < getBitfehlerrate() ? bitFailure : daten[i];
        }).toArray(Byte[]::new);
        for (int i = 0; i < data.length; i++) {
            daten[i] = data[i];
        }
        return Arrays.copyOfRange(daten, start, start + lng);
    }

    /**
     * Returns the bit error rate of the medium.
     *
     * @return the bit error rate of the medium
     */
    public double getBitfehlerrate() {
        return bitfehlerrate;
    }

    /**
     * Returns a string representation of the medium.
     *
     * @return a string representation of the medium
     */
    public String toString() {
        return getClass().getSimpleName() + ": Daten:" + Arrays.toString(daten) + ", Kapazität: " + getKapazitaet() + ", Bitfehlerrate: " + getBitfehlerrate();
    }
}
