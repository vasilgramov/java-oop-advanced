package p02_kingGambit.core;

import p02_kingGambit.castle.CastleImpl;
import p02_kingGambit.models.Footman;
import p02_kingGambit.models.RoyalGuard;
import p02_kingGambit.castle.Castle;

import java.util.Scanner;

/**
 * Created by vladix on 4/12/17.
 */
public class CommandHandlerImpl implements CommandHandler {

    private Castle castle;

    public CommandHandlerImpl() {
        this.castle = new CastleImpl();
    }

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);

        String kingName = in.nextLine();
        this.castle.setKing(kingName);

        String[] royalGuards = in.nextLine().split("\\s+");
        this.addGuards(royalGuards);

        String[] footmen = in.nextLine().split("\\s+");
        this.addFootmen(footmen);

        String line = in.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String commandType = tokens[0];

            if (commandType.equals("Attack")) {
                this.castle.attack();
            } else if (commandType.equals("Kill")) {
                String name = tokens[1];
                this.castle.killPerson(name);
            }

            line = in.nextLine();
        }
    }

    private void addFootmen(String[] footmen) {
        for (String footman : footmen) {
            this.castle.addPerson(new Footman(footman));
        }
    }

    private void addGuards(String[] royalGuards) {
        for (String royalGuard : royalGuards) {
            this.castle.addPerson(new RoyalGuard(royalGuard));
        }
    }
}
