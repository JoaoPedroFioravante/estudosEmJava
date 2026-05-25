import java.util.Objects;

public final class Rectangle extends Figure{
    private final double width;
    private final double length;

    public Rectangle(double x, double y, double width, double length){
        super(x,y);
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width*length;
    }

    @Override
    public String toString() {
        return "Rectangle " + super.toString() + String.format("width = %.2f length = %.2f", width, length);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!super.equals(obj)) return false;
        if(obj instanceof Rectangle compared){
            return compared.getWidth() == width &&
                    compared.getLength() == length;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, length);
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
}
