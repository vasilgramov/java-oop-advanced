package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

public class AddCommand extends Command {

    protected AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String[] data = super.getData();
        String unitType = data[1];

        Unit unit = super.getUnitFactory().createUnit(unitType);

        super.getRepository().addUnit(unit);

        return String.format("%s added!", unitType);
    }
}
