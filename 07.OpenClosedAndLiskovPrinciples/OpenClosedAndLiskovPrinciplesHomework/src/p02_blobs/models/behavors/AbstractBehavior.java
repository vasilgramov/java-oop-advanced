package p02_blobs.models.behavors;


import p02_blobs.interfaces.Behavior;
import p02_blobs.models.Blob;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;
    private boolean toDelayRecurrentEffect;

    public AbstractBehavior() {
        this.toDelayRecurrentEffect = true;
    }

    public boolean isTriggered() {
        return this.isTriggered;
    }

    public void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    public boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }
}
