package p01_jarOfT;

public class Main {

    public static void main(String[] args) {
        Jar<String> jarOfStrings = new Jar<>();

        jarOfStrings.add("Pesho");
        jarOfStrings.add("Goshko");
        jarOfStrings.add("Stamatcho");

        System.out.println(jarOfStrings.remove());
    }
}
