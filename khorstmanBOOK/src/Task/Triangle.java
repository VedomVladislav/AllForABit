package Task;

public class Triangle extends Figure {

    private double x;
    private double y;

    public Triangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double square() {
        return x*y/2;
    }
}
