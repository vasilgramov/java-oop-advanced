package p02_blobs.models.behavors;


import p02_blobs.models.Blob;

public class Aggressive extends AbstractBehavior {

    private static final int AGGRESSIVE_DAMAGE_MULTIPLY = 2;
    private static final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

    private int sourceInitialDamage;

    public Aggressive() {
        super();
    }

    public void trigger(Blob source) {
        this.sourceInitialDamage = source.getDamage();
        super.setIsTriggered(true);
        this.applyTriggerEffect(source);
    }

    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setDamage(source.getDamage() - AGGRESSIVE_DAMAGE_DECREMENT);

            if (source.getDamage() <= this.sourceInitialDamage) {
                source.setDamage(this.sourceInitialDamage);
            }
        }
    }

    public boolean toDelayRecurrentEffect() {
        return super.isTriggered();
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        super.setToDelayRecurrentEffect(toDelayRecurrentEffect);
    }

    private void applyTriggerEffect(Blob source) {
        source.setDamage(source.getDamage() * AGGRESSIVE_DAMAGE_MULTIPLY);
    }
}
