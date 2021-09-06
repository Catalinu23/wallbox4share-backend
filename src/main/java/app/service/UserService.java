package app.service;

import app.entity.User;
import app.entity.Wallbox;
import app.repository.UserRepository;
import app.repository.WallboxRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private WallboxRepository wallboxRepository;

    public User getUserById(Long id) {
        return repository.getById(id);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public void addWallbox(Long userId, Long wallboxId) {
        log.info("Loading user from db");
        User user = repository.findById(userId)
                              .orElseThrow(EntityNotFoundException::new);
        log.info("Loading wallbox from db");
        Wallbox wallbox = wallboxRepository.findById(wallboxId)
                                           .orElseThrow(EntityNotFoundException::new);
        log.info("Adding wallbox to user");
        user.addWallbox(wallbox);
    }

}
