package Media;

public class Festplatte extends MediumBeschreibbar{

    protected Festplatte(long length) {
        super(length, 1/Math.pow(10,15));
    }
}
