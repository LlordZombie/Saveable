package Media;

public class MediumBeschreibbar extends MediumNurLesbar {
    private final long length;

    protected MediumBeschreibbar(long length, double bitfehlerrate) {
        super(new byte[(int) ((length / 2147483647) + 1)][2147483647], bitfehlerrate);
        this.length = length;
    }

    protected void schreiben(long start, byte[][] datenNeu) {
        long newKap = start;
        for (byte[] bytes : datenNeu) {
            newKap += bytes.length;
        }
        if (newKap> getKapazitaet()){
            throw new IllegalArgumentException("Too much data");
        }
        for (long i = start; i < newKap; i++) {

        }

    }

    @Override
    protected byte[][] lesen(long start, long lng) {
        changeLastLen();
        return super.lesen(start, lng);
    }

    @Override
    protected double getBitfehlerrate() {
        changeLastLen();
        return super.getBitfehlerrate();
    }

    @Override
    protected long getKapazitaet() {
        changeLastLen();
        return super.getKapazitaet();
    }

    private void changeLastLen() {
        if (daten[daten.length - 1].length != length % 2147483647) {
            daten[daten.length - 1] = new byte[(int) (length % 2147483647)];
        }
    }
}
