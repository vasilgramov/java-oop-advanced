package p03_dependencyInversion.strategy;

/**
 * Created by vladix on 4/12/17.
 */
public class StrategyImpl implements StrategyGetterChanger {

    private char strategy;

    public StrategyImpl() {
        this.strategy = '+';
    }

    @Override
    public char getStrategy() {
        return this.strategy;
    }

    @Override
    public void changeStrategy(char newStrategy) {
        this.strategy = newStrategy;
    }
}
