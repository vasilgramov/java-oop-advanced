package app.models.engines;

public class SterndriveEngine extends AbstractEngine {
    private static final int MODIFIER = 7;

    public SterndriveEngine(int horsePower, int displacement) {
        super(horsePower * MODIFIER, displacement);
    }
}
