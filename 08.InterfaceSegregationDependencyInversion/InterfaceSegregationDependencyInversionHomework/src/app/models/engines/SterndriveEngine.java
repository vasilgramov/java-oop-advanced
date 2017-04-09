package app.models.engines;

public class SterndriveEngine extends AbstractEngine {
    private static final int MODIFIER = 7;

    public SterndriveEngine(String model, int horsePower, int displacement) {
        super(model, horsePower * MODIFIER, displacement);
    }
}
