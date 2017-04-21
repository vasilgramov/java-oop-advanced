package app.interfaces;

import app.models.Blob;

public interface Attack {

    void execute(Blob attacker, Blob target);

}
