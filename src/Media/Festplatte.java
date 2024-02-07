package Media;

public class Festplatte extends MediumBeschreibbar {

    public Festplatte(long length) {
        super(length, 1 / Math.pow(10, 15));
    }

    public void schreiben(long start, byte[][] datenNeu) {
        super.schreiben(start, datenNeu);

    }

    @Override
    public byte[][] lesen(long start, long lng) {
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
