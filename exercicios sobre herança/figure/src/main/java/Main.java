public class Main {
    public static void main(){
        Circle circle1 =  new Circle(0, 1, 2);
        Circle circle2 =  new Circle(0, 1, 2);
        Circle circle3 =  new Circle(1, 1, 2);
        Triangle triangle1 = new Triangle(10, 11, 3, 4, 5);
        Triangle triangle2 = new Triangle(10, 11, 3, 3, 5);
        Triangle triangle3 = new Triangle(10, 11, 3, 4, 5);
        Rectangle rectangle1 = new Rectangle(2,4, 2, 3);
        Rectangle rectangle2 = new Rectangle(2,4, 2, 3);
        Rectangle rectangle3 = new Rectangle(3,5, 2, 3);

        System.out.println(circle1);
        System.out.println(circle1.area());
        System.out.println(triangle1);
        System.out.println(triangle1.area());
        System.out.println(rectangle1);
        System.out.println(rectangle1.area());

        System.out.println("==============igualdade=================\n");
        System.out.println(circle1.equals(circle2));
        System.out.println(circle1.equals(circle3));
        System.out.println(circle2.equals(circle3));
        System.out.println("------------------");
        System.out.println(triangle1.equals(triangle2));
        System.out.println(triangle1.equals(triangle3));
        System.out.println(triangle2.equals(triangle3));
        System.out.println("------------------");
        System.out.println(rectangle1.equals(rectangle2));
        System.out.println(rectangle1.equals(rectangle3));
        System.out.println(rectangle2.equals(rectangle3));
    }
}

