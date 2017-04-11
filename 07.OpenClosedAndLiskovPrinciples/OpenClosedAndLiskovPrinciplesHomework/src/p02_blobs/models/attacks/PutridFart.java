package p02_blobs.models.attacks;


import p02_blobs.interfaces.Attack;
import p02_blobs.models.Blob;

public class PutridFart implements Attack {

    public void execute(Blob source, Blob target) {
        target.respond(source.getDamage());
    }
}
