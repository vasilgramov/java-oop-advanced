package bg.softuni.io;

import bg.softuni.annotations.Alias;
import bg.softuni.annotations.Inject;
import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.commands.*;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;

public class CommandInterpreter {

    private static final String COMMANDS_LOCATION = "src/bg/softuni/io/commands";
    private static final String COMMANDS_PACKAGE = "bg.softuni.io.commands.";

    private Tester tester;
    private StudentsRepository repository;
    private DownloadManager downloadManager;
    private IOManager ioManager;

    public CommandInterpreter(Tester tester,
                              StudentsRepository repository,
                              DownloadManager downloadManager,
                              IOManager ioManager) {
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.ioManager = ioManager;
    }

    public void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Command command = parseCommand(input, data, commandName);
            command.execute();
        } catch (Exception ex) {
            OutputWriter.displayException(ex.getMessage());
        }
    }

    private Command parseCommand(String input, String[] data, String command) {
        File commandsFolder = new File(COMMANDS_LOCATION);
        Command executable = null;

        for (File file : commandsFolder.listFiles()) {
            if (!file.isFile() && !file.getName().endsWith(".java")) {
                continue;
            }

            try {
                String className = file.getName()
                        .substring(0, file.getName().lastIndexOf('.'));

                Class<Command> exeClass = (Class<Command>) Class.forName(COMMANDS_PACKAGE + className);
                if (!exeClass.isAnnotationPresent(Alias.class)) {
                    continue;
                }

                Alias alias = exeClass.getAnnotation(Alias.class);
                String value = alias.value();
                if (!value.equals(command)) {
                    continue;
                }

                Constructor exeCtor = exeClass.getConstructor(String.class, String[].class);
                executable = (Command) exeCtor.newInstance(input, data);

                this.injectDependencies(executable, exeClass);
            } catch (ReflectiveOperationException roe) {
                roe.printStackTrace();
            }
        }

        return executable;
    }

    private void injectDependencies(Command executable, Class<Command> exeClass) throws IllegalAccessException {
        Field[] declaredFields = exeClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!declaredField.isAnnotationPresent(Inject.class)) {
                continue;
            }

            declaredField.setAccessible(true);

            Field[] fields = CommandInterpreter.class.getDeclaredFields();
            for (Field field : fields) {
                if (!field.getType().equals(declaredField.getType())) {
                    continue;
                }

                field.setAccessible(true);
                declaredField.set(executable, field.get(this));
                break;
            }
        }
    }
}
