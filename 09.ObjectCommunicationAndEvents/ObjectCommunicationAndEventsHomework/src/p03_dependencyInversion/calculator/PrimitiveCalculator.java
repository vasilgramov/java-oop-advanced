package p03_dependencyInversion.calculator;


import p03_dependencyInversion.strategy.StrategyChanger;
import p03_dependencyInversion.strategy.StrategyGetterChanger;
import p03_dependencyInversion.strategy.StrategyImpl;

/**
 * Created by vladix on 4/12/17.
 */
public class PrimitiveCalculator implements Calculator, StrategyChanger {

    private StrategyGetterChanger strategy;

    public PrimitiveCalculator() {
        this.strategy = new StrategyImpl();
    }

    @Override
    public void changeStrategy(char newStrategy) {
        this.strategy.changeStrategy(newStrategy);
    }

    @Override
    public void performCalculation(int firstOperand, int secondOperand) {

        switch (this.strategy.getStrategy()) {
            case '+':
                System.out.println(firstOperand + secondOperand);
                break;
            case '-':
                System.out.println(firstOperand - secondOperand);
                break;
            case '*':
                System.out.println(firstOperand * secondOperand);
                break;
            case '/':
                System.out.println(firstOperand / secondOperand);
                break;
        }

    }


}
