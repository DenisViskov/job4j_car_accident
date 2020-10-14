package di;

import java.util.ArrayList;
import java.util.List;

/**
 * Class is a store
 *
 * @author Денис Висков
 * @version 1.0
 * @since 14.10.2020
 */
public class Store {
    /**
     * Data
     */
    private List<String> data = new ArrayList<String>();

    /**
     * Add value to store
     *
     * @param value
     */
    public void add(String value) {
        data.add(value);
    }

    /**
     * Return data
     *
     * @return List
     */
    public List<String> getAll() {
        return data;
    }
}
