package p05_borderControl;

import p05_borderControl.interfaces.Buyer;
import p05_borderControl.models.Citizen;
import p05_borderControl.models.Rebel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Buyer> buyersByName = new HashMap<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] buyerArgs = in.nextLine().split("\\s+");
            String buyerName = buyerArgs[0];
            Buyer buyer = getBuyer(buyerArgs);
            buyersByName.put(buyerName, buyer);
        }

        String command = "";
        while (!"End".equals(command = in.nextLine())) {
            String name = command;
            if (buyersByName.containsKey(name)) {
                Buyer buyer = buyersByName.get(name);
                buyer.buyFood();
            }
        }

        int total = 0;
        for (Buyer buyer : buyersByName.values()) {
            total += buyer.getFood();
        }

        System.out.println(total);
    }

    private static Buyer getBuyer(String[] buyerArgs) {
        if (buyerArgs.length == 3) {
            return new Rebel(buyerArgs[0], Integer.parseInt(buyerArgs[1]), buyerArgs[2]);
        } else {
            return new Citizen(buyerArgs[0], Integer.parseInt(buyerArgs[1]), buyerArgs[2], buyerArgs[3]);
        }
    }
}
