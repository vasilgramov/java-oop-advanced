package p03_dependencyInversion.strategy;

/**
 * Created by vladix on 4/12/17.
 */
public class StrategyImpl implements Strategy {

    private char strategy;

    public StrategyImpl() {
    }

    @Override
    public char getStrategy() {
        return this.strategy;
    }

    @Override
    public void changeStrategy(char operator) {
        this.strategy = operator;
    }
}
