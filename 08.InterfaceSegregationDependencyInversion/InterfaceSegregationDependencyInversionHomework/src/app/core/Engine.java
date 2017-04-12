package app.core;

import app.contracts.CommandHandler;
import app.contracts.Database;
import app.database.DatabaseImpl;
import app.exeptions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Engine {
    private CommandHandler commandHandler;

    public Engine(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            List<String> tokens = new ArrayList<>();
            String[] split = line.split("\\\\");
            if (split.length >= 2 && split[1].equals("Turbo220")) {
                int x = 0;
            }
            tokens.addAll(Arrays.asList(split));

            try {
                String commandResult = this.commandHandler.executeCommand(tokens);
                System.out.println(commandResult);
            }  catch (InvocationTargetException e) {
                System.out.println(e.getTargetException().getMessage());
            } catch (IllegalAccessException | InstantiationException | NoSetRaceException | DuplicateModelException | RaceAlreadyExistsException | NonExistantModelException | ClassNotFoundException | InsufficientContestantsException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            line = scanner.nextLine();
        }
    }
}
