package accident.control;

import accident.model.Accident;
import accident.model.AccidentEntity;
import accident.repository.AccidentHibernate;
import accident.repository.AccidentJdbcTemplate;
import accident.repository.AccidentRepository;
import accident.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 19.10.2020
 */
@Controller
public class IndexControl {

    private final AccidentRepository accidents;

    public IndexControl(AccidentRepository accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<AccidentEntity> res = new ArrayList<>();
        accidents.findAll().forEach(res::add);
        model.addAttribute("accidents", res);
        return "index";
    }
}
