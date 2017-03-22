package p05_comparingObjects;

public interface Human extends Comparable<Human>{
    String getName();

    int getAge();

    String getTown();
}
