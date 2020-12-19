package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.User;
import lt.sdacademy.university.models.entities.UserEntity;
import lt.sdacademy.university.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractBiConverter<UserEntity, User> {

    private final UserRepository userRepository;

    public UserConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User convert(UserEntity userEntity) {
        return new User(
            userEntity.getId(),
            userEntity.getEmail(),
            userEntity.getName()
        );
    }

    @Override
    public UserEntity convertToEntity(User user) {
        UserEntity result = new UserEntity();

        if (user.getId() != null) {
            result = userRepository.findById(user.getId());
        }

        result.setEmail(user.getEmail());
        result.setPassword(user.getPassword());
        result.setName(user.getName());

        return result;
    }
}
