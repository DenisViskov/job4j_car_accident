package accident.control;

import accident.model.Accident;
import accident.repository.AccidentMem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 19.10.2020
 */
@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {
        AccidentMem mem = new AccidentMem();
        Set<Accident> list = new HashSet<>(mem.getAccidents().values());
        model.addAttribute("accidents", list);
        return "index";
    }
}
