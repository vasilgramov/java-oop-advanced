package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class CommandPattern {
    public static Command createCommand(String commandName, String[] data, Repository repository, UnitFactory unitFactory) {
        Command command = null;
        switch (commandName) {
            case "add":
                command = new AddCommand(data, repository, unitFactory);
                break;
            case "retire":
                command = new RetireCommand(data, repository, unitFactory);
                break;
            case "report":
                command = new ReportCommand(data, repository, unitFactory);
                break;
            case "fight":
                command = new FightCommand(data, repository, unitFactory);
                break;
        }

        return command;
    }
}
