public class Main {
    public static void main(){
        System.out.println("valids");
        System.out.println(Email.isValid("joao@gmail.com"));
        System.out.println(Email.isValid("maria.silva@empresa.com.br"));
        System.out.println(Email.isValid("user123@hotmail.com"));
        System.out.println(Email.isValid("a@b.com"));
        System.out.println("============= invalids body");
        System.out.println(Email.isValid("@gmail.com"));
        System.out.println(Email.isValid("joao..silva@gmail.com"));
        System.out.println(Email.isValid("joao#@gmail.com"));
        System.out.println("------------------ invalids domain");
        System.out.println(Email.isValid("joaogmail.com"));
        System.out.println(Email.isValid("joao@@gmail.com"));
        System.out.println(Email.isValid("joao@gmail@com"));
        System.out.println(Email.isValid("joao@gmail..com"));
        System.out.println(Email.isValid("joao@gmail.com"));
    }
}
