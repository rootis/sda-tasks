package lt.sdacademy.university.controllers;

import lt.sdacademy.university.models.dto.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/sing-up")
    public User signUp(@RequestBody User user) {
        // TODO: implement
        return null;
    }
}
