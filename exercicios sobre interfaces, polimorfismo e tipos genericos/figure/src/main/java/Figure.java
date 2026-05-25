import java.util.Objects;

public sealed abstract class Figure permits Circle, Rectangle, Triangle {
    protected final double x;
    protected final double y;

    public Figure(double x, double y){
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    @Override
    public String toString() {
        return "position x = "+x+" position y = "+y;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Figure figureCompared){
            return x == figureCompared.getX() &&
                    y == figureCompared.getY();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
