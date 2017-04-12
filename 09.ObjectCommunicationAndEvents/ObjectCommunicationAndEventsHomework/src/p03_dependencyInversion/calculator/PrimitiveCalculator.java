package p03_dependencyInversion.calculator;

import p03_dependencyInversion.strategy.Strategy;

/**
 * Created by vladix on 4/12/17.
 */
public class PrimitiveCalculator implements Calculator {

    private Strategy strategy;

    public PrimitiveCalculator(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void performCalculation(int firstOperand, int secondOperand) {
        switch (this.strategy.getStrategy()) {
//            case '+'
        }
    }


}
