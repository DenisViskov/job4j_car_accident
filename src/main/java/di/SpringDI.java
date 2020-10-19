package di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Class is a spring DI
 *
 * @author Денис Висков
 * @version 1.0
 * @since 14.10.2020
 */
public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("di");
        context.refresh();
        Store store = context.getBean(Store.class);
        store.add("Petr Arsentev");
        Store another = context.getBean(Store.class);
        another.getAll().forEach(System.out::println);
    }
}
