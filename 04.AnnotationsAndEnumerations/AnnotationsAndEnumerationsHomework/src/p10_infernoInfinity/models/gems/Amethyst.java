package p10_infernoInfinity.models.gems;

import p10_infernoInfinity.enums.GemType;
import p10_infernoInfinity.interfaces.Gem;

public class Amethyst extends BaseGem implements Gem {

    public Amethyst() {
        super(GemType.AMETHYST.getStrength(), GemType.AMETHYST.getAgility(), GemType.AMETHYST.getVitality());
    }
}
