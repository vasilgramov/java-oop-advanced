package p02_blobs.interfaces;

import p02_blobs.models.Blob;

public interface Attack {
    void execute(Blob attacker, Blob target);
}
