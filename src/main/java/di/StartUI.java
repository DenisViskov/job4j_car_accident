package di;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 14.10.2020
 */
public class StartUI {
    private Store store;

    public StartUI(Store store) {
        this.store = store;
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}
