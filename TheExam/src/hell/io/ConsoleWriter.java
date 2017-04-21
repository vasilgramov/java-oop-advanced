package hell.io;

import hell.interfaces.OutputWriter;

/**
 * Created by vladix on 4/21/17.
 */
public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {

    }

}
