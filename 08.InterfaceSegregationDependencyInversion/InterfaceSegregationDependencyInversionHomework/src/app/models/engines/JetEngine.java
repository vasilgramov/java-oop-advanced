package app.models.engines;

public class JetEngine extends AbstractEngine {
    private static final int MODIFIER = 5;

    public JetEngine(String model, int horsePower, int displacement) {
        super(model, horsePower * MODIFIER, displacement);
    }
}
