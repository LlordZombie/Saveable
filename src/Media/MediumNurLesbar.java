package Media;

import java.util.Arrays;

public class MediumNurLesbar {//TODO: OutOfMemoryError beheben, bitfehlerrate einbinden
    protected byte[][] daten;
    protected double bitfehlerrate;

    protected MediumNurLesbar(byte[][] daten, double bitfehlerrate) {
        this.bitfehlerrate = bitfehlerrate;
        this.daten = Arrays.copyOf(daten, daten.length);
    }

    protected static byte[][] resize(byte[][] daten, long newLen) {
        byte[][] r = new byte[(int)(newLen/2147483645 +1)][];
        for (int i = 0; i < newLen / 2147483645; i++) {
            r[i] = new byte[2147483645];
        }
        r[r.length - 1] = new byte[(int) (newLen % 2147483645)];
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                try {
                    r[i][j] = daten[i][j];
                } catch (ArrayIndexOutOfBoundsException e) {
                    r[i][j] = 0;
                }
            }
        }
        return r;
    }

    protected long getKapazitaet() {
        int r = 0;
        for (byte[] bytes : daten) {
            r += bytes.length;
        }
        return r;
    }

    protected byte[][] lesen(long start, long lng) {
        if (Long.compareUnsigned(getKapazitaet(), start + lng) < 0) {
            throw new IllegalArgumentException("There is less Data than you want to read");
        }
        int maxlen = 2147483645;
        byte[][] r = new byte[(int) (lng / maxlen) + 1][(int) (lng % maxlen)];
        for (long i = 0; i < lng; i++) {
            long originalIndex = i + start;
            r[(int) i / maxlen][(int) i % maxlen] = daten[(int) originalIndex / maxlen][(int) originalIndex % maxlen];
        }
        return r;
    }

    protected double getBitfehlerrate() {
        return bitfehlerrate;
    }


}