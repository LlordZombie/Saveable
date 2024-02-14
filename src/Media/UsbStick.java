package Media;

/**
 * The UsbStick class represents a USB stick medium that can be written and read.
 * It extends the MediumBeschreibbar class.
 */
public class UsbStick extends MediumBeschreibbar {
    /** The maximum number of write cycles allowed for this USB stick. */
    private final int schreibzyklen;
    /** The number of operations performed on this USB stick. */
    private int opsDone = 0;

    /**
     * Constructs a new UsbStick object with the specified length and maximum write cycles.
     *
     * @param length The length of the USB stick in bytes.
     * @param schreibzyklen The maximum number of write cycles allowed for the USB stick.
     */
    public UsbStick(int length, int schreibzyklen) {
        super(length, 0.001);
        this.schreibzyklen = schreibzyklen;
    }

    /**
     * Writes the specified data to the USB stick starting from the specified index.
     *
     * @param start The starting index to write the data.
     * @param datenNeu The data to be written to the USB stick.
     */
    public void schreiben(int start, byte[] datenNeu) {
        opsDone++;
        bitfehlerrate *= (opsDone >= schreibzyklen) ? (bitfehlerrate < 1 ? 1.1 : 1) : 1;
        super.schreiben(start, datenNeu);
    }

    /**
     * Reads the data from the USB stick starting from the specified index with the specified length.
     *
     * @param start The starting index to read the data.
     * @param lng The length of data to be read.
     * @return The data read from the USB stick.
     */
    @Override
    public byte[] lesen(int start, int lng) {
        opsDone++;
        bitfehlerrate *= (opsDone >= schreibzyklen) ? (bitfehlerrate < 1 ? 1.1 : 1) : 1;
        return super.lesen(start, lng);
    }

    /**
     * Returns a string representation of this USB stick, including its remaining efficient operations.
     *
     * @return A string representation of this USB stick.
     */
    public String toString() {
        return super.toString() + ", Übrige effiziente Operationen: " + (schreibzyklen > opsDone ? schreibzyklen - opsDone : 0);
    }
}
