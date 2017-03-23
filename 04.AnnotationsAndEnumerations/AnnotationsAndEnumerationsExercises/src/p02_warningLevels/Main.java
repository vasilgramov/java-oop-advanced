package p02_warningLevels;

import p02_warningLevels.enums.Importance;
import p02_warningLevels.models.Logger;
import p02_warningLevels.models.Message;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String lowerBoundary = in.nextLine();
        Logger logger = new Logger(Importance.valueOf(lowerBoundary));

        String command = in.nextLine();
        while (!"END".equals(command)) {
            String[] commandArgs = command.split(": ");
            Importance importance = Importance.valueOf(commandArgs[0]);
            String content = commandArgs[1];

            Message message = new Message(importance, content);
            logger.record(message);

            command = in.nextLine();
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
