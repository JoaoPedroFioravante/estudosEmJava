public final class Rectangle extends Figure{
    private final double width;
    private final double length;

    public Rectangle(double x, double y, double width, double length){
        super(x,y);
        this.width = width;
        this.length = length;
    }

    @Override//equals feito por mim
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(getClass() != obj.getClass()) return false;
        Rectangle that = (Rectangle) obj;
        return width == that.width && length == that.length
                && getX() == that.getX() && getY() == that.getY();
    }

    @Override
    public String toString() {
        return String.format("rectangle: position x = %.2f position y = %.2f width = %.2f length = %.2f",
                getX(), getY(), width, length);
    }

    @Override
    public double area(){
        return width*length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
}
