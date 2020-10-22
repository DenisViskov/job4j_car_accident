package accident.control;

import accident.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 19.10.2020
 */
@Controller
public class IndexControl {
    @Autowired
    private final RepositoryService service;

    public IndexControl(RepositoryService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", service.getAllAccidents());
        return "index";
    }
}
