package p07_equalityLogic.interfaces;

public interface Human extends Comparable<Human> {
    String getName();

    int getAge();
}
