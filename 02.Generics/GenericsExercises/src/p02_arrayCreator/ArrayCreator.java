package p02_arrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <E> E[] create(int length, E item) {
        E[] elements = (E[]) new Object[10];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = item;
        }

        return elements;
    }

    @SuppressWarnings("unchecked")
    public static <E> E[] create(Class<E> eClass, int length, E item) {
        E[] array = (E[]) Array.newInstance(eClass, length);
        for (int i = 0; i < length; i++) {
            array[i] = item;
        }

        return array;
    }
}
