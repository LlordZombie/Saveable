package Media;

public class DVD extends MediumNurLesbar {

    public DVD(byte[][] daten) {
        super(MediumNurLesbar.resize(daten, Long.parseLong("8500000000")), (double) 1 / 50000);
    }

    public double getBitfehlerrate() {
        return super.getBitfehlerrate();
    }

    public long getKapazitaet() {
        return super.getKapazitaet();
    }

    public byte[][] lesen(long start, long lng) {
        return super.lesen(start, lng);
    }
}
