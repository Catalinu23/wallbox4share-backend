package app.controller;

import app.entity.User;
import app.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO Class description.
 *
 * @author Szocs, Arpad (arpad.szocs@msg.group)
 * @since 8/25/2021
 */
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userid}")
    public User findUserById(@PathVariable Long userid) {
        return userService.getUserById(userid);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }


}
