package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.User;
import lt.sdacademy.university.models.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractBiConverter<UserEntity, User> {

    @Override
    public User convert(UserEntity obj) {
        return null;
    }

    @Override
    public UserEntity convertToEntity(User obj) {
        return null;
    }
}
