import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//annotation valida apenas para classes
//que terão o atributo name que é o nome da tabela que será salvo os dados
public @interface Table {
    String name();
}


