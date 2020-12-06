package lt.sdacademy.university.controllers;

import lt.sdacademy.university.models.dto.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonAgeController {

    @GetMapping("/zmogus")
    public Person getPerson() {
        return new Person("Rutenis", 31);
    }
}
