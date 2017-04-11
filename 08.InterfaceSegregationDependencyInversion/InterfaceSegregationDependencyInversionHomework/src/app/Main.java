package app;

import app.contracts.CommandHandler;
import app.contracts.Database;
import app.core.CommandHandlerImpl;
import app.core.Engine;
import app.database.DatabaseImpl;

public class Main {

    public static void main(String[] args) {
        Database database = new DatabaseImpl();

        CommandHandler commandHandler = new CommandHandlerImpl(database);
        Engine engine = new Engine(commandHandler);
        engine.run();
    }
}
