package p05_square;

public class Rectangle {
    private int width;
    private int height;

    protected Rectangle(int width) {
        this(width, width);
    }

    public Rectangle(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public int getWidth() {
        return width;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    public void increase() {
        this.setWidth(this.getWidth() + (10 * this.getWidth()) / 100);
        this.setHeight(this.getHeight() + (10 * this.getHeight()) / 100);
     }
}
