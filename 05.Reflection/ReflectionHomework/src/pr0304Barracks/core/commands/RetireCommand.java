package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class RetireCommand extends Command {

    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try {
            super.getRepository().removeUnit(super.getData()[1]);
            return String.format("%s retired!", super.getData()[1]);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
