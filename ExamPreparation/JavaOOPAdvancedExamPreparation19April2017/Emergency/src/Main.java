import core.ManagementSystem;
import core.ManagementSystemImpl;
import engines.CommandInterpreter;
import engines.CommandInterpreterImpl;
import engines.Engine;
import io.readers.ConsoleReader;
import io.readers.Reader;
import io.writers.ConsoleWriter;
import io.writers.Writer;

/**
 * Created by vladix on 4/18/17.
 */
public class Main {

    public static void main(String[] args) {

        Writer writer = new ConsoleWriter();
        Reader reader = new ConsoleReader();
        ManagementSystem emergencyManagementSystem = new ManagementSystemImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(emergencyManagementSystem);
        Runnable engine = new Engine(reader, writer, commandInterpreter);
        engine.run();

    }
}
