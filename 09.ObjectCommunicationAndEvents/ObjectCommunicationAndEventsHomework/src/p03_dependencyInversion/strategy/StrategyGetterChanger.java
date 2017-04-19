package p03_dependencyInversion.strategy;

/**
 * Created by vladix on 4/19/17.
 */
public interface StrategyGetterChanger extends StrategyChanger {

    char getStrategy();

}
