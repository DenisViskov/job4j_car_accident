package accident.control;

import accident.model.Accident;
import accident.model.AccidentType;
import accident.model.Rule;
import accident.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
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
        List<AccidentType> types = service.getAllTypes();
        List<Rule> rules = service.getAllRules();
        model.addAttribute("types", types);
        model.addAttribute("rules", rules);
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        Arrays.stream(ids).forEach(id -> accident.addRule(Rule.of(Integer.valueOf(id), "")));
        service.saveAccident(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", service.findByIdAccident(id).get());
        return "accident/edit";
    }
}
