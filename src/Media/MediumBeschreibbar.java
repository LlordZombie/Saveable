package Media;

/**
 * This class represents a writable medium, extending the functionality of a read-only medium.
 */
class MediumBeschreibbar extends MediumNurLesbar {

    /**
     * Constructs a writable medium with the given length and bit error rate.
     *
     * @param length         The length of the medium.
     * @param bitfehlerrate  The bit error rate of the medium.
     */
    protected MediumBeschreibbar(int length, double bitfehlerrate) {
        super(new byte[length], bitfehlerrate);
    }

    /**
     * Writes data to the medium starting from the specified position.
     *
     * @param start      The starting position to write the data.
     * @param datenNeu   The new data to be written.
     * @throws IllegalArgumentException if there is not enough space to write the data.
     */
    public void schreiben(int start, byte[] datenNeu) {
        if (start + datenNeu.length > getKapazitaet())
            throw new IllegalArgumentException("There is not enough space");

        for (int i = 0; i < daten.length; i++) {
            byte bitFailure = (byte) (daten[i] ^ (1 << ((int) (Math.random() * 8))));
            daten[i] = Math.random() < getBitfehlerrate() ? bitFailure : daten[i];
        }

        System.arraycopy(datenNeu, 0, daten, start, datenNeu.length);
    }
}
