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
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}
