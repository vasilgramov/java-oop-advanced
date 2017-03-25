package p10_infernoInfinity.models.gems;

import p10_infernoInfinity.enums.GemType;
import p10_infernoInfinity.interfaces.Gem;

public class Emerald extends BaseGem implements Gem {

    public Emerald() {
        super(GemType.EMERALD.getStrength(), GemType.EMERALD.getAgility(), GemType.EMERALD.getVitality());
    }
}
