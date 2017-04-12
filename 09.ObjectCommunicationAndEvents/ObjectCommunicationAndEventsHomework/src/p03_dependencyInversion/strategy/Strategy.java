package p03_dependencyInversion.strategy;

/**
 * Created by vladix on 4/12/17.
 */
public interface StrategyChanger {

    char getStrategy();

    void changeStrategy(char operator);

}
