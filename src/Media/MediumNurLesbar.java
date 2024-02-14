package Media;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

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
        Random random = new Random();
        Byte[] data = IntStream.range(0, daten.length).mapToObj(i -> {
            byte bitFailure = (byte) (daten[i] ^ (1 << random.nextInt(8)));
            return random.nextDouble() < getBitfehlerrate() ? bitFailure : daten[i];
        }).toArray(Byte[]::new);
        for (int i = 0; i < data.length; i++) {
            daten[i] = data[i];
        }
        return Arrays.copyOfRange(daten, start, start + lng);
    }


    public double getBitfehlerrate() {
        return bitfehlerrate;
    }

    public String toString() {
        return getClass().getSimpleName() + ": Daten:" + Arrays.toString(daten) + ", Kapazität: " + getKapazitaet() + ", Bitfehlerrate: " + getBitfehlerrate();
    }
}