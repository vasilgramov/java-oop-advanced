package io.writers;

/**
 * Created by vladix on 4/18/17.
 */
public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
