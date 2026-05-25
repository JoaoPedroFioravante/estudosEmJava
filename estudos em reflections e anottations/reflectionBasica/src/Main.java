import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;


public class Main {
    static void main() throws InvocationTargetException, IllegalAccessException {
        Pessoa pessoa = new Pessoa(LocalDate.of(2000, 2, 2), "testando", "2303-4985");
        Method[] methods = pessoa.getClass().getDeclaredMethods();
        /*for(var method: methods) {
            if (!method.getName().contains("set")) {
                method.setAccessible(true);
                System.out.print(method.getName() + " " + method.getParameterCount() + " ");
                if(method.getReturnType() == void.class){
                    if(method.getName().equals("calling")){
                        method.invoke(pessoa, "pedro");
                    }else{
                    method.invoke(pessoa);
                    }
                }
                else {
                    System.out.println(method.invoke(pessoa));
                }
            }
        }*/

        Field[] fields = pessoa.getClass().getDeclaredFields();
        /*for (Field field : fields) {
            if(!field.canAccess(pessoa)){
                field.setAccessible(true);
            }
            System.out.println(field.getName());
            System.out.println(field.get(pessoa));
            if(field.getName().equals("name")) {
                field.set(pessoa,"teste" );
                System.out.println(field.get(pessoa));
            }
            System.out.println("============");
        }
        */
        /*
        try {
            Constructor<?> constructorPessoa = Pessoa.class.getDeclaredConstructor(LocalDate.class, String.class, String.class);
            Object objectPessoa = constructorPessoa.newInstance(LocalDate.of(2000,1,1), "joao", "2309-2342");
            Method[] methodsPessoaJoao = objectPessoa.getClass().getDeclaredMethods();
            for (Method method : methodsPessoaJoao) {
                if(method.getName().contains("get")){
                    System.out.print(method.getName()+ "  ");
                    System.out.println(method.invoke(objectPessoa));
                }
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
         */
        //o que é private e o que é publico?
        for (Field field : fields) {
            if (!field.canAccess(pessoa)) {
                System.out.println(field.getName() + " é privado");
            }
            else {
                System.out.println(field.getName() + " é publico");
            }
        }
        for (Method method : methods) {
            if(!method.canAccess(pessoa)){
                System.out.println(method.getName() +" é privado");
            }
            else {
                System.out.println(method.getName() + " é publico");
            }
        }
    }
}
