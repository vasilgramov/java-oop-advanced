package p10_infernoInfinity.models.gems;

import p10_infernoInfinity.enums.GemType;
import p10_infernoInfinity.interfaces.Gem;

public class Ruby extends BaseGem implements Gem {

    public Ruby() {
        super(GemType.RUBY.getStrength(), GemType.RUBY.getAgility(), GemType.RUBY.getVitality());
    }
}
