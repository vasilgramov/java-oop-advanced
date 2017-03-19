package p10_tuple;

public class Tuple<K, V> {
    private K item1;
    private V item2;

    public Tuple(K item1, V item2) {
        this.setItem1(item1);
        this.setItem2(item2);
    }

    public K getItem1() {
        return this.item1;
    }

    private void setItem1(K item1) {
        this.item1 = item1;
    }

    public V getItem2() {
        return this.item2;
    }

    private void setItem2(V item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getItem1(), this.getItem2());
    }
}
