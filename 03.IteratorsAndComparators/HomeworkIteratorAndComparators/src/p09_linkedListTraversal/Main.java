package p09_linkedListTraversal;

import p09_linkedListTraversal.iterfaces.LinkedList;
import p09_linkedListTraversal.models.MyLinkedList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedList<Integer> myLinkedList = new MyLinkedList<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandArgs = in.nextLine().split("\\s+");
            String commandType = commandArgs[0];
            if (commandType.equals("Add")) {
                myLinkedList.add(Integer.parseInt(commandArgs[1]));
            } else {
                myLinkedList.remove(Integer.parseInt(commandArgs[1]));
            }
        }

        System.out.println(myLinkedList.getSize());
        for (Integer integer : myLinkedList) {
            System.out.print(integer + " ");
        }
    }
}
