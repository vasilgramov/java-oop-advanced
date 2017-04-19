package engines;

import commands.Executable;
import io.readers.Reader;
import io.writers.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/18/17.
 */
public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;

    private CommandInterpreter commandInterpreter;

    public Engine(Reader reader,
                  Writer writer,
                  CommandInterpreter commandInterpreter) {
        this.reader = reader;
        this.writer = writer;

        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() {

        try {
            String line = this.reader.readLine();
            while (!line.equals("EmergencyBreak")) {

                String[] tokens = line.split("\\|");
                String commandType = tokens[0];
                Executable executable = this.commandInterpreter.execute(commandType);
                String result = executable.execute(tokens);
                this.writer.writeLine(result);

                line = this.reader.readLine();
            }

        } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
