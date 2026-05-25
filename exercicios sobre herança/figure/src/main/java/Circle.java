import java.util.Objects;

public final class Circle extends Figure {
    private final double radius;

    public Circle(double x, double y, double radius){
        super(x, y);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("circle: position x = %.2f position y = %.2f radius = %.2f", getX(), getY(), radius);
    }

    @Override//equal gerado pelo intellij
    public boolean equals(Object o) {
        if (!(o instanceof Circle circle)) return false;
        return Double.compare(radius, circle.radius) == 0 &&
                getX() == circle.getX() && getY() == circle.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }

    @Override
    public double area(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }
}
