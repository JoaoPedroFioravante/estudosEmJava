public final class Triangle extends Figure {
    private double a;
    private double b;
    private double c;

    public Triangle(double x, double y, double a, double b, double c){
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(getClass() != obj.getClass()) return true;
        Triangle that = (Triangle) obj;
        return getX() == that.getX() && getY() == that.getY()
                && a == that.getA() && b == that.getB() && c == that.getC();
    }

    @Override
    public String toString() {
        return String.format("triangle: position x = %.2f y = %.2f a = %.2f b = %.2f  c = %.2f",
                getX(), getY(), a, b, c);
    }

    @Override
    public double area() {
        //adotei y como altura baseado que y começa em 0 e termina no ponto maximo do triangulo
        //e b sendo a base, deixo a area universal para todos triangulos
        return (b*getY())/2;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
