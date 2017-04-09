package app.database;

import app.contracts.Database;
import app.contracts.Repository;

public class DatabaseImpl implements Database {
    private Repository boats;
    private Repository engines;

    public DatabaseImpl() {
        this.setBoats(new RepositoryImpl());
        this.setEngines(new RepositoryImpl());
    }

    @Override
    public Repository getBoats() {
        return this.boats;
    }

    private void setBoats(RepositoryImpl boats) {
        this.boats = boats;
    }

    @Override
    public Repository getEngines() {
        return this.engines;
    }

    private void setEngines(RepositoryImpl engines) {
        this.engines = engines;
    }
}
