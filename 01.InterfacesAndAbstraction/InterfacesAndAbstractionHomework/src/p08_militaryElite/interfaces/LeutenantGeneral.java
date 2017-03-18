package p08_militaryElite.interfaces;

import java.util.Collection;

public interface LeutenantGeneral extends Private {
    Collection<Private> getPrivates();

    void addPrivate(Private privateSoldier);
}
