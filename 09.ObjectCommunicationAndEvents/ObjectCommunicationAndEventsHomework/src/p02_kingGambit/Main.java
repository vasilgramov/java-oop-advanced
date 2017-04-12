package p02_kingGambit;

import p02_kingGambit.core.CommandHandlerImpl;
import p02_kingGambit.core.CommandHandler;

/**
 * Created by vladix on 4/12/17.
 */
public class Main {

    public static void main(String[] args) {

        CommandHandler commandHandler = new CommandHandlerImpl();
        commandHandler.execute();

    }
}
