package app.core;

import app.contracts.CommandHandler;
import app.contracts.Database;
import app.database.DatabaseImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {
    private CommandHandler commandHandler;

    public Engine(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while (line.equals("End")) {
            List<String> tokens = Arrays.asList(line.split("\\\\"));
            String name = tokens.get(0);
            List<String> parameters = tokens.stream().skip(1).collect(Collectors.toList());

            try {
                String commandResult = this.commandHandler.executeCommand(name, parameters);
                System.out.println(commandResult);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            line = scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        Database database = new DatabaseImpl();

        CommandHandler commandHandler = new CommandHandlerImpl(database);
        Engine engine = new Engine(commandHandler);
        engine.run();
    }
}
