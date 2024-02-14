package Media;

import java.util.Arrays;

class MediumNurLesbar {
    protected byte[] daten;
    protected double bitfehlerrate;

    protected MediumNurLesbar(byte[] daten, double bitfehlerrate) {
        this.bitfehlerrate = bitfehlerrate;
        this.daten = Arrays.copyOf(daten, daten.length);
    }


    public long getKapazitaet() {
        return daten.length;
    }

    public byte[] lesen(int start, int lng) {
        if (start + lng > getKapazitaet())
            throw new IllegalArgumentException("There is less Data than you want to read");
        for (int i = 0; i < daten.length; i++) {
            byte bitFailure = (byte) (daten[i] ^ (1 << ((int) (Math.random() * 8))));
            daten[i] = Math.random() < getBitfehlerrate() ? bitFailure : daten[i];
        }
        return Arrays.copyOfRange(daten, start, start + lng);
    }

    public double getBitfehlerrate() {
        return bitfehlerrate;
    }
    public String toString(){
        return getClass().getSimpleName()+": Daten:"+Arrays.toString(daten)+", Kapazität: "+getKapazitaet()+", Bitfehlerrate: "+getBitfehlerrate();
    }
}