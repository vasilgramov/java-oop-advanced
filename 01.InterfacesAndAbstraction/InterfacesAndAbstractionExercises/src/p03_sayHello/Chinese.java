package p03_sayHello;

public class Chinese extends BasePerson implements Person {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Ni hao";
    }
}
