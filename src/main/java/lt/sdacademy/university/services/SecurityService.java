package lt.sdacademy.university.services;

import lt.sdacademy.university.converters.UserConverter;
import lt.sdacademy.university.models.dto.User;
import lt.sdacademy.university.models.entities.UserEntity;
import lt.sdacademy.university.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    public SecurityService(UserConverter userConverter, UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    public User signUp(User user) {
        UserEntity userEntity = userConverter.convertToEntity(user);
        userEntity.setPassword(user.getPassword()); //reik encriptint

        return userConverter.convert(userRepository.save(userEntity));
    }
}
