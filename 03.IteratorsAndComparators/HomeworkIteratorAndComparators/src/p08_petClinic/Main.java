package p08_petClinic;

import p08_petClinic.interfaces.Animal;
import p08_petClinic.interfaces.Hospital;
import p08_petClinic.models.Clinic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        CommandManager commandManager = new CommandManager();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandArgs = in.nextLine().split("\\s+");
            String commandType = commandArgs[0];

            if (commandType.equals("Create")) {
                if (commandArgs[1].equals("Pet")) {
                    commandManager.createPet(commandArgs[2], Integer.parseInt(commandArgs[3]), commandArgs[4]);
                } else {
                    commandManager.createClinic(commandArgs[2], Integer.parseInt(commandArgs[3]));
                }
            } else if (commandType.equals("Add")) {
                System.out.println(commandManager.addPet(commandArgs[1], commandArgs[2]));
            } else if (commandType.equals("Release")) {
                System.out.println(commandManager.release(commandArgs[1]));
            } else if (commandType.equals("HasEmptyRooms")) {
                System.out.println(commandManager.hasEmptyRooms(commandArgs[1]));
            } else if (commandType.equals("Print")) {
                if (commandArgs.length == 2) {
                    commandManager.print(commandArgs[1]);
                } else {
                    commandManager.printRoom(commandArgs[1], Integer.parseInt(commandArgs[2]));
                }
            }
        }
    }
}
