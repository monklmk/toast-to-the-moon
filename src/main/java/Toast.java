import zero.GameApp;

public class Toast {
    private double x;
    private double y;
    private double size;

    public Toast(double x, double y, double startSize) {
        this.x = x;
        this.y = y;
        this.size = startSize;
    }

    public void grow(double amount) {
        size += amount;
    }

    public double getSize() {
        return size;
    }

    public boolean contains(double mx, double my) {
        double half = size / 2.0;
        return Math.abs(mx - x) <= half && Math.abs(my - y) <= half;
    }

    public void draw(GameApp app) {
        double half = size / 2.0;
        app.rect(x-half, y-half, size, size);
    }
}
