package di;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 14.10.2020
 */
public class Store {
    private List<String> data = new ArrayList<String>();

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}
