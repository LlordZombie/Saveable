package Media;

/**
 * The Festplatte class represents a hard drive, which is a writable medium.
 * It inherits from the MediumBeschreibbar class.
 */
public class Festplatte extends MediumBeschreibbar {

    /**
     * Constructs a Festplatte object with the specified length.
     *
     * @param length The length of the hard drive in bytes.
     */
    public Festplatte(int length) {
        super(length, 0.001); // Calls the constructor of the superclass with the given length and density.
    }
}
