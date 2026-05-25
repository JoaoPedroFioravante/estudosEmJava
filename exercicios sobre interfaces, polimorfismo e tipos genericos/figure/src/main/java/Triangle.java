import java.util.Objects;

public final class Triangle extends Figure {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double x, double y, double a, double b, double c){
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area(){
        return b*y/2;
        //adotei b como base e y como altura só para fim de testes já que é um triangulo geral
    }

    @Override
    public String toString() {
        return "triangle "+ super.toString() + String.format("a = %.2f b = %.2f c = %.2f",a,b,c);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!super.equals(obj)) return false;
        if(obj instanceof Triangle compared){
            return compared.getA() == a &&
                    compared.getB() == b &&
                    compared.getC() == c;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), a, b, c);
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
