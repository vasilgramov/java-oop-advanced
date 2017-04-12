package p01_evenImplementation;

import java.util.Scanner;

/**
 * Created by vladix on 4/12/17.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Dispatcher dispatcher = new Dispatcher();
        String command = in.nextLine();
        while (!command.equals("End")) {
            dispatcher.changeName(command);

            command = in.nextLine();
        }
    }
}
