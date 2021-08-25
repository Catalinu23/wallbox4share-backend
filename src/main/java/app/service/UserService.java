package app.service;

import app.entity.User;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * TODO Class description.
 *
 * @author Szocs, Arpad (arpad.szocs@msg.group)
 * @since 8/25/2021
 */
@Service
public interface UserService {

    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);
}
