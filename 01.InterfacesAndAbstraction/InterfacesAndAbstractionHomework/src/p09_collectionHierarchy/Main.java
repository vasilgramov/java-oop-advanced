package p09_collectionHierarchy;

import p09_collectionHierarchy.interfaces.AddCollection;
import p09_collectionHierarchy.interfaces.MyList;
import p09_collectionHierarchy.interfaces.RemoveCollection;
import p09_collectionHierarchy.models.AddCollectionImpl;
import p09_collectionHierarchy.models.MyListImpl;
import p09_collectionHierarchy.models.RemoveCollectionImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        AddCollection addCollection = new AddCollectionImpl();
        RemoveCollection removeCollection = new RemoveCollectionImpl();
        MyList myList = new MyListImpl();

        String[] elements = in.nextLine().split("\\s+");
        for (String element : elements) {
            System.out.print(addCollection.add(element) + " ");
        }

        System.out.println();

        for (String element : elements) {
            System.out.print(removeCollection.add(element) + " ");
        }

        System.out.println();

        for (String element : elements) {
            System.out.print(myList.add(element) + " ");
        }

        System.out.println();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print(removeCollection.remove() + " ");
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(myList.remove() + " ");
        }

        System.out.println();
    }
}
