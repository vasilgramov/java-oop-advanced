package p02_blobs.interfaces;

import p02_blobs.models.Blob;

public interface Behavior {

    boolean isTriggered();

    void setIsTriggered(boolean isTriggered);

    boolean toDelayRecurrentEffect();

    void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect);

    void applyRecurrentEffect(Blob source);

    void trigger(Blob source);
}
