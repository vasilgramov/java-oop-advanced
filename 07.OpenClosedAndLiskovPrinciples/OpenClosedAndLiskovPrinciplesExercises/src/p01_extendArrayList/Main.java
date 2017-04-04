package p01_extendArrayList;

public class Main {

    public static void main(String[] args) {
        ExtendedArrayList<Integer> myList = new ExtendedArrayList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);

        System.out.println(myList.min());
        System.out.println(myList.max());
    }
}
