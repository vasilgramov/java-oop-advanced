package app.commands;

import app.models.station.RecyclingStation;
import app.models.wastes.BaseGarbage;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/20/17.
 */
public class ProcessGarbageCommand extends BaseCommand {


    private static final String GARBAGE = "Garbage";
    private static final String WASTES_PATH = "app.models.wastes.";

    public ProcessGarbageCommand(RecyclingStation recyclingStation,
                                 GarbageProcessor garbageProcessor) {
        super(recyclingStation, garbageProcessor);
    }


    public String execute(String[] tokens) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String garbageType = tokens[tokens.length - 1];     // last token is the garbage type
        Class<?> wasteClass = Class.forName(WASTES_PATH + garbageType + GARBAGE);

        String name = tokens[1];
        double weight = Double.parseDouble(tokens[2]);
        double volumePerKG = Double.parseDouble(tokens[3]);

        Constructor<?> constructor = wasteClass.getConstructor(String.class, double.class, double.class);
        BaseGarbage waste = ((BaseGarbage) constructor.newInstance(name, weight, volumePerKG));

        ProcessingData processingData = super.getGarbageProcessor().processWaste(waste);
        String filter = super.getRecyclingStation().getFilter();
        if (filter == null || !filter.equals(garbageType)) {
            super.getRecyclingStation().processData(processingData);

            return String.format("%.2f kg of %s successfully processed!", waste.getWeight(), waste.getName());
        } else {
            double currentEnergy = super.getRecyclingStation().getEnergy();
            double currentCapital = super.getRecyclingStation().getCapital();

            double minEnergy = super.getRecyclingStation().getMinEnergy();
            double minCapital = super.getRecyclingStation().getMinCapital();

            if (currentEnergy < minEnergy ||
                    currentCapital < minCapital) {
                return "Processing Denied!";
            } else {
                super.getRecyclingStation().processData(processingData);
                return String.format("%.2f kg of %s successfully processed!", waste.getWeight(), waste.getName());
            }
        }
    }
}
