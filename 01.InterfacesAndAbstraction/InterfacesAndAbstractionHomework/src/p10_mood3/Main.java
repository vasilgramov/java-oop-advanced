package p10_mood3;

import p10_mood3.interfaces.Character;
import p10_mood3.models.Archangel;
import p10_mood3.models.Demon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] characterArgs = in.nextLine().split(" \\| ");

        if (characterArgs[1].equals("Demon")) {
            Character demon = new Demon(characterArgs[0], Double.parseDouble(characterArgs[2]), Integer.parseInt(characterArgs[3]));
            System.out.println(demon);
        } else {
            Character archangel = new Archangel(characterArgs[0], Integer.parseInt(characterArgs[2]), Integer.parseInt(characterArgs[3]));
            System.out.println(archangel);
        }
    }
}
