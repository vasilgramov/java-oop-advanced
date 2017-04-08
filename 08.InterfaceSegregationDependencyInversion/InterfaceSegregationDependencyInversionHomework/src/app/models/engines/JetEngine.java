package app.models.engines;

public class JetEngine extends AbstractEngine {
    private static final int MODIFIER = 5;

    public JetEngine(int horsePower, int displacement) {
        super(horsePower * MODIFIER, displacement);
    }
}
