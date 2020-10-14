package di;

import java.io.IOException;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 14.10.2020
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Context context = new Context();
        context.reg(ConsoleInput.class);
        context.reg(Store.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
        ui.enterMessage();
    }
}
