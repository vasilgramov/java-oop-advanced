package p04_listUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        Collections.addAll(integerList, 1, 2, 3, 4, 5, 6);
        Collections.addAll(doubleList, 1.1, 2.2, 3.3, 4.4);

        List<List<? extends Number>> nestedList = new ArrayList<>();
        nestedList.add(integerList);
        nestedList.add(doubleList);

        List<Number> flatten = new ArrayList<>();
        ListUtils.flatten(flatten, nestedList);
        System.out.println(flatten);

        //-----------------------------------------------

//        System.out.println("Min: " + ListUtils.getMin(integerList));
//        System.out.println("Max: " + ListUtils.getMax(integerList));
//
//        List<String> stringList = new ArrayList<>();
//        Collections.addAll(stringList, "avi", "vladix");
//
//        List<String> nullableList = new ArrayList<>();
//        Collections.addAll(nullableList, "gosho", "pesho", "ani", null, "vladix", null);
//
//        System.out.println("Min: " + ListUtils.getMin(stringList));
//        System.out.println("Max: " + ListUtils.getMax(stringList));
//
//        System.out.println(ListUtils.getNullIndices(nullableList));
    }
}
