package Media;

public class UsbStick extends MediumBeschreibbar {
    private final int schreibzyklen;
    private int opsDone = 0;

    public UsbStick(long length, int schreibzyklen) {
        super(length, 1 / Math.pow(10, 15));
        this.schreibzyklen = schreibzyklen;
    }

    public void schreiben(long start, byte[][] datenNeu) {
        super.schreiben(start, datenNeu);
        opsDone++;
        if (opsDone >= schreibzyklen) {
            bitfehlerrate += bitfehlerrate < 1 ? 0.1 : 0;
        }
    }

    @Override
    public byte[][] lesen(long start, long lng) {
        opsDone++;
        if (opsDone >= schreibzyklen) {
            bitfehlerrate += bitfehlerrate < 1 ? 0.1 : 0;
        }
        return super.lesen(start, lng);
    }

    @Override
    public double getBitfehlerrate() {
        return super.getBitfehlerrate();
    }

    @Override
    public long getKapazitaet() {
        return super.getKapazitaet();
    }
}
