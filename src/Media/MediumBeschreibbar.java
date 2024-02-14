package Media;

class MediumBeschreibbar extends MediumNurLesbar {

    protected MediumBeschreibbar(int length, double bitfehlerrate) {
        super(new byte[length], bitfehlerrate);
    }

    public void schreiben(int start, byte[] datenNeu) {
        if (start + datenNeu.length > getKapazitaet()) throw new IllegalArgumentException("There is not enough space");
        for (int i = 0; i < daten.length; i++) {
            byte bitFailure = (byte) (daten[i] ^ (1 << ((int) (Math.random() * 8))));
            daten[i] = Math.random() < getBitfehlerrate() ? bitFailure : daten[i];
        }
        System.arraycopy(datenNeu, 0, daten, start, datenNeu.length);
    }

}
