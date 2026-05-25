import java.util.Objects;

public final class Circle extends Figure{
    private final double radius;

    public Circle(double x, double y, double radius){
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(radius, 2);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!super.equals(obj)) return false;
        if(obj instanceof Circle compared){
            return compared.getRadius() == radius;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    @Override
    public String toString() {
        return "circle " + super.toString() + " radius = "+radius;
    }

    public double getRadius() {
        return radius;
    }
}
