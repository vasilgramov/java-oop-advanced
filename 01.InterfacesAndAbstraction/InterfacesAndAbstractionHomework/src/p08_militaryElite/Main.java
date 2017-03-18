package p08_militaryElite;

import p08_militaryElite.interfaces.*;
import p08_militaryElite.models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Private> privateById = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        String command = "";
        while (!"End".equals(command = in.nextLine())) {
            String[] commandArgs = command.split("\\s+");

            String soldierType = commandArgs[0];
            if (soldierType.equals("Private")) {
                Private privateSoldier = new PrivateImpl(Integer.parseInt(commandArgs[1]), commandArgs[2], commandArgs[3], Double.parseDouble(commandArgs[4]));
                privateById.put(Integer.parseInt(commandArgs[1]), privateSoldier);
                System.out.println(privateSoldier);
            } else if (soldierType.equals("Spy")) {
                Spy spy = new SpyImpl(Integer.parseInt(commandArgs[1]), commandArgs[2], commandArgs[3], Integer.parseInt(commandArgs[4]));
                System.out.println(spy);
            } else if (soldierType.equals("LeutenantGeneral")) {
                LeutenantGeneral leutenantGeneral = new LeutenantGeneralImp(
                        Integer.parseInt(commandArgs[1]), commandArgs[2], commandArgs[3], Double.parseDouble(commandArgs[4]));
                addPrivatesTo(leutenantGeneral, commandArgs);
                System.out.println(leutenantGeneral);
            } else if (soldierType.equals("Engineer")) {
                Engineer engineer = new EngineerImpl(
                        Integer.parseInt(commandArgs[1]), commandArgs[2], commandArgs[3], Double.parseDouble(commandArgs[4]), commandArgs[5]);

                if (engineer.getCorps() == null) {
                    continue;
                } else {
                    getRepairs(engineer, commandArgs);
                    System.out.println(engineer);
                }
            } else if (soldierType.equals("Commando")) {
                Commando commando = new CommandoImpl(
                        Integer.parseInt(commandArgs[1]), commandArgs[2], commandArgs[3], Double.parseDouble(commandArgs[4]), commandArgs[5]);

                if (commando.getCorps() == null) {
                    continue;
                } else {
                    getMissions(commando, commandArgs);
                    System.out.println(commando);
                }
            }
        }
    }

    private static void getMissions(Commando commando, String[] commandArgs) {
        for (int i = 6; i < commandArgs.length; i += 2) {
            String codeName = commandArgs[i];
            String state = commandArgs[i + 1];
            Mission mission = new MissionImp(codeName, state);
            if (mission.getState() != null) {
                commando.addMission(mission);
            }
        }
    }

    private static void getRepairs(Engineer engineer, String[] commandArgs) {
        for (int i = 6; i < commandArgs.length; i += 2) {
            String partName = commandArgs[i];
            int houresWorked = Integer.parseInt(commandArgs[i + 1]);
            Repair repair = new RepairImpl(partName, houresWorked);
            engineer.addRepair(repair);
        }
    }

    private static void addPrivatesTo(LeutenantGeneral leutenantGeneral, String[] commandArgs) {
        for (int i = 5; i < commandArgs.length; i++) {
            int id = Integer.parseInt(commandArgs[i]);
            if (privateById.containsKey(id)) {
                Private privateSoldier = privateById.get(id);
                leutenantGeneral.addPrivate(privateSoldier);
            }
        }
    }
}
