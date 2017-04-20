package app.core;

import app.io.reader.Reader;
import app.io.writer.Writer;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.StrategyHolder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/19/17.
 */
public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private CommandInterpretator commandInterpretator;

    public Engine(Reader reader, Writer writer, CommandInterpretator commandInterpretator) {
        this.reader = reader;
        this.writer = writer;
        this.commandInterpretator = commandInterpretator;
    }

    @Override
    public void run() {

        try {
            String line = this.reader.readLine();
            while (!"TimeToRecycle".equals(line)) {
                String result = this.commandInterpretator.execute(line);
                this.writer.writeLine(result);

                line = this.reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
