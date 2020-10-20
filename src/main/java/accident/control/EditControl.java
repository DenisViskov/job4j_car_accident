package accident.control;

import accident.model.Accident;
import accident.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 20.10.2020
 */
@Controller
public class EditControl {
    @Autowired
    private final RepositoryService service;

    public EditControl(RepositoryService service) {
        this.service = service;
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("accidents", service.getAll());
        return "accident/edit";
    }

    @PostMapping("/editAccident")
    public String editAccident(@ModelAttribute Accident accident) {
        service.update(accident);
        return "redirect:/";
    }
}
