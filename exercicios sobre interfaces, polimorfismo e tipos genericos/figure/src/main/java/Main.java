public class Main {
    public static void main() {
        Figure[] figures = new Figure[150];
        double area = 0;
        for(int i = 0; i<50; i++){
            figures[i] = new Circle(i, i, i+1);
            figures[i+50] = new Triangle(i, i+3, i+3, i+4, i+5);//triangulo retangulo
            figures[i+100] = new Rectangle(i+1, i+1, i+2, i+2);
            area += figures[i].area() + figures[i+50].area() + figures[i+100].area();
        }
        System.out.println(figures[100].area());
        System.out.println(figures[50].area());
        System.out.println(figures[0].area());
        // areas calculadando corretamente
        Figure triangulo = new Triangle(0, 3, 3, 4,5);
        System.out.println(figures[50].equals(figures[51]));
        System.out.println(figures[50].equals(triangulo));
        System.out.println(figures[50]);
        System.out.println(area);
    }
}
