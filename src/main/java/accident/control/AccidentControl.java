package accident.control;

import accident.model.Accident;
import accident.model.AccidentType;
import accident.repository.AccidentMem;
import accident.repository.Store;
import accident.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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
    public String create(Model model) {
        List<AccidentType> types = service.getAccidentTypes();
        model.addAttribute("types", types);
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        service.save(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", service.findById(id).get());
        return "accident/edit";
    }
}
