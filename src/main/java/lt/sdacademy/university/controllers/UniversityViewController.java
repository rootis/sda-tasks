package lt.sdacademy.university.controllers;

import lt.sdacademy.university.services.UniversityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/universities")
public class UniversityViewController {

    private final UniversityService universityService;

    public UniversityViewController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public String getUniversities(Model model) {
        /*
            return universityService.getUniversities();
        }*/
        model.addAttribute("headerText", "SDA Spring Course");
        model.addAttribute("pageTitle", "Universities");

        return "page";
    }
}
