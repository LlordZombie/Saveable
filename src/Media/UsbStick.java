package Media;

public class UsbStick extends MediumBeschreibbar {
    private final int schreibzyklen;
    private int opsDone = 0;

    public UsbStick(int length, int schreibzyklen) {
        super(length, 0.001);
        this.schreibzyklen = schreibzyklen;
    }

    public void schreiben(int start, byte[] datenNeu) {
        opsDone++;
        if (opsDone >= schreibzyklen) bitfehlerrate *= bitfehlerrate < 1 ? 1.1 : 1;
        super.schreiben(start, datenNeu);
    }

    @Override
    public byte[] lesen(int start, int lng) {
        opsDone++;
        if (opsDone >= schreibzyklen) bitfehlerrate *= bitfehlerrate < 1 ? 1.1 : 1;
        return super.lesen(start, lng);
    }

    public String toString() {
        return super.toString() + ", Übrige effiziente Operationen: " + (schreibzyklen > opsDone ? schreibzyklen - opsDone : 0);
    }
}
