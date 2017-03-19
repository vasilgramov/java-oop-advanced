package p11_threeuple;

public class Threeuple<K, V, P> {
    private K item1;
    private V item2;
    private P item3;

    public Threeuple(K item1, V item2, P item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
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

    public P getItem3() {
        return this.item3;
    }

    private void setItem3(P item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
               return String.format("%s -> %s -> %s", this.getItem1(), this.getItem2(), this.getItem3());
    }
}
