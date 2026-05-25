public sealed class Figure permits Triangle, Rectangle, Circle {
    private final double x;
    private final double y;

    public Figure(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double area(){
        return 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
