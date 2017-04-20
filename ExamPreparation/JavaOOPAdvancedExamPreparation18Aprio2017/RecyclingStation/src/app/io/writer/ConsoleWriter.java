package app.io.writer;

/**
 * Created by vladix on 4/19/17.
 */
public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

}
