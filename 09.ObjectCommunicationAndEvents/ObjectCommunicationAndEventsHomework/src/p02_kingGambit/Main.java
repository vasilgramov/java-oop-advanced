package p02_kingGambit;

import p02_kingGambit.core.CommandHandler;
import p02_kingGambit.core.CommandHandlerImpl;

/**
 * Created by vladix on 4/12/17.
 */
public class Main {

    public static void main(String[] args) {

        CommandHandler commandHandler = new CommandHandlerImpl();
        commandHandler.execute();

    }
}
