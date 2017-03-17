package testing;

/**
 * Created by vladix on 3/17/17.
 */
public class Main {

    public static void main(String[] args) {
        Tray tray = new Tray();
        Glass<Liquid> glass = new Glass<>();

        tray.add(glass);
    }
}
