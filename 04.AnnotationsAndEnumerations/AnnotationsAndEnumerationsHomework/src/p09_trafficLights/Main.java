package p09_trafficLights;

import p09_trafficLights.enums.TrafficLight;

import java.util.Scanner;

public class Main {
    private static TrafficLight[] allTrafficLights = TrafficLight.values();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        String[] input = in.nextLine().split("\\s+");
        TrafficLight[] trafficLights = new TrafficLight[input.length];
        for (int i = 0; i < input.length; i++) {
            trafficLights[i] = TrafficLight.valueOf(input[i]);
        }

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                int currentIndex = getCurrentLightIndex(trafficLights[j]) + 1;
                currentIndex = currentIndex >= allTrafficLights.length ? 0 : currentIndex;

                trafficLights[j] = allTrafficLights[currentIndex];
                System.out.print(allTrafficLights[currentIndex] + " ");
            }

            System.out.println();
        }
    }

    private static int getCurrentLightIndex(TrafficLight trafficLight) {
        int index = -1;
        for (int i = 0; i < allTrafficLights.length; i++) {
            if (allTrafficLights[i] == trafficLight) {
                index = i;
                return index;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("No such trafficlight exists!");
        }

        return index;
    }
}
