package app.core;

import app.contracts.CommandHandler;
import app.contracts.Database;
import app.database.DatabaseImpl;

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
            } catch (Exception ex) {
                if (ex.getMessage() != null) {
                    System.out.println(ex.getMessage());
                }
            }

            line = scanner.nextLine();
        }
    }
}
