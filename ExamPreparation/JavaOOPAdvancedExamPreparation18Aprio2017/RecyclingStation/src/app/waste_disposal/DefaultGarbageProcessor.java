package app.waste_disposal;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.*;

import java.lang.annotation.Annotation;

public class DefaultGarbageProcessor implements GarbageProcessor {

    private static final String STRATEGY_PATH = "app.models.processors.";
    private static final String STRATEGY = "DisposalStrategy";

    private StrategyHolder strategyHolder;

    public DefaultGarbageProcessor(StrategyHolder strategyHolder){
        this.setStrategyHolder(strategyHolder);
    }

    @Override
    public StrategyHolder getStrategyHolder() {
        return this.strategyHolder;
    }

    private void setStrategyHolder(StrategyHolder strategyHolder) {
        if (strategyHolder == null) {
            throw new IllegalArgumentException("Strategy is null!");
        }

        this.strategyHolder = strategyHolder;
    }

    @Override
    public ProcessingData processWaste(Waste garbage) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (garbage == null) {
            throw new IllegalArgumentException("Garbage is null");
        }

        Class type = garbage.getClass();
        Annotation[] garbageAnnotations = type.getAnnotations();
        Class disposableAnnotation = null;
        for (Annotation annotation : garbageAnnotations) {
            if(annotation.annotationType().isAnnotationPresent(Disposable.class)) {
                disposableAnnotation = annotation.annotationType();
                break;
            }
        }

        if (disposableAnnotation == null) {
            throw new IllegalArgumentException(
                    "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.");
        }

        GarbageDisposalStrategy currentStrategy;
        if (!this.getStrategyHolder().getDisposalStrategies().containsKey(disposableAnnotation)) {
            String simpleName = disposableAnnotation.getSimpleName();
            Class<?> aClass = Class.forName(STRATEGY_PATH + simpleName + STRATEGY);
            GarbageDisposalStrategy strategy = ((GarbageDisposalStrategy) aClass.newInstance());
            this.strategyHolder.addStrategy(disposableAnnotation, strategy);
        }

        currentStrategy = this.getStrategyHolder().getDisposalStrategies().get(disposableAnnotation);
        return currentStrategy.processGarbage(garbage);
    }
}
