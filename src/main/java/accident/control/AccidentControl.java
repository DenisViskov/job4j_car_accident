package accident.control;

import accident.model.Accident;
import accident.repository.AccidentMem;
import accident.repository.Store;
import accident.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 20.10.2020
 */
@Controller
public class AccidentControl {
    @Autowired
    private final RepositoryService service;

    public AccidentControl(RepositoryService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        service.save(accident);
        return "redirect:/";
    }
}
