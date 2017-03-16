package p03_scale;

public class Scale<E extends Comparable<E>> {
    private E left;
    private E right;

    public Scale(E left, E right) {
        this.setLeft(left);
        this.setRight(right);
    }

    private void setLeft(E left) {
        this.left = left;
    }

    private void setRight(E right) {
        this.right = right;
    }

    public E getHeavier() {
        if (this.left.compareTo(this.right) > 0) {
            return this.left;
        } else if (this.right.compareTo(this.left) > 0) {
            return this.right;
        }

        return null;
    }
}
