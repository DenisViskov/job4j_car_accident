package di;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class is a console input
 *
 * @author Денис Висков
 * @version 1.0
 * @since 14.10.2020
 */
public class ConsoleInput {
    /**
     * Method of enter message from console
     *
     * @return message
     * @throws IOException
     */
    public String input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = reader.readLine();
        return in;
    }
}
