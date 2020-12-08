package Task;

public class Square extends Figure {

    private double x;
    private double y;

    public Square(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double square() {
        return x*y;
    }
}
