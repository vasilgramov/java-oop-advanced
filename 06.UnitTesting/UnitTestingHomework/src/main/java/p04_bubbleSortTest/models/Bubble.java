package p04_bubbleSortTest.models;

import javax.naming.OperationNotSupportedException;

public class Bubble<E extends Comparable<E>> {

    private E[] elements;

    public Bubble(E[] elements) throws OperationNotSupportedException {
        this.setElements(elements);
    }

    public E[] getElements() {
        return this.elements;
    }

    private void setElements(E[] elements) throws OperationNotSupportedException {
        if (elements == null) {
            throw new OperationNotSupportedException("Elements should not be null!");
        }

        this.elements = elements;
    }

    public void applyBubbleSort() {
        for (int i = 0; i < this.elements.length; i++) {
            boolean hasSwapped = false;

            for (int j = 0; j < this.elements.length - 1 - i; j++) {
                E left = this.elements[j];
                E right = this.elements[j + 1];

                if (left.compareTo(right) > 0) {
                    hasSwapped = true;

                    this.elements[j + 1] = left;
                    this.elements[j] = right;
                }
            }

            if (!hasSwapped) {
                break;
            }
        }
    }

}
