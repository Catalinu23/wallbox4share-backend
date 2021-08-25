package app.service;

import app.entity.User;
import app.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO Class description.
 *
 * @author Szocs, Arpad (arpad.szocs@msg.group)
 * @since 8/23/2021
 */
@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    public User getUserById(Long id){
        return repository.getById(id);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public void saveUser(User user){
        repository.save(user);
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }

}
