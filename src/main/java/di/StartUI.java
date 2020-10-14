package di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Class is a start ui
 *
 * @author Денис Висков
 * @version 1.0
 * @since 14.10.2020
 */
@Component
public class StartUI {
    /**
     * Store
     */
    @Autowired
    private Store store;
    /**
     * ConsoleInput
     */
    @Autowired
    private ConsoleInput consoleInput;

    /**
     * Method add value to store
     *
     * @param value
     */
    public void add(String value) {
        store.add(value);
    }

    /**
     * Method of print from store
     */
    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    /**
     * Method of input massage from console and printing him
     *
     * @throws IOException
     */
    public void enterMessage() throws IOException {
        System.out.println(consoleInput.input());
    }
}
