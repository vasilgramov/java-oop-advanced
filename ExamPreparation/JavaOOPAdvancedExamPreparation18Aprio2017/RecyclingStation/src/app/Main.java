package app;

import app.core.CommandInterpretator;
import app.core.CommandInterpretatorImpl;
import app.core.Engine;
import app.io.reader.ConsoleReader;
import app.io.reader.Reader;
import app.io.writer.ConsoleWriter;
import app.io.writer.Writer;
import app.models.station.RecyclingStation;
import app.models.station.RecyclingStationImpl;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.StrategyHolder;

public class Main {

    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        RecyclingStation recyclingStation = new RecyclingStationImpl();

        StrategyHolder strategyHolder = new DefaultStrategyHolder();
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);

        CommandInterpretator commandInterpretator = new CommandInterpretatorImpl(garbageProcessor, recyclingStation);

        Runnable runnable = new Engine(reader, writer, commandInterpretator);
        runnable.run();

    }
}
