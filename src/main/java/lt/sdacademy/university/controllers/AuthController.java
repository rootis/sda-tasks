package lt.sdacademy.university.controllers;

import javax.validation.Valid;
import lt.sdacademy.university.models.dto.User;
import lt.sdacademy.university.services.SecurityService;
import lt.sdacademy.university.validators.UserValidator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserValidator userValidator;
    private final SecurityService securityService;

    public AuthController(UserValidator userValidator, SecurityService securityService) {
        this.userValidator = userValidator;
        this.securityService = securityService;
    }

    @PostMapping("/sign-up")
    public User signUp(@RequestBody @Valid User user) {
        userValidator.validate(user);

        return securityService.signUp(user);
    }
}
