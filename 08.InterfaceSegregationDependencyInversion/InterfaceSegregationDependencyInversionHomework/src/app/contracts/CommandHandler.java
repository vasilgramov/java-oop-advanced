package app.contracts;

import app.exeptions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CommandHandler {
    String executeCommand(List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
