package app.controller;

import app.entity.User;

import java.util.List;

import app.entity.Wallbox;
import app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * TODO Class description.
 *
 * @author Szocs, Arpad (arpad.szocs@msg.group)
 * @since 8/25/2021
 */
@RestController
@CrossOrigin
@Slf4j
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

    @PostMapping("/users/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        log.info(user.getId() + " " + user.getEmail() + " " + user.getUsername() + " " + user.getPassword());
        userService.saveUser(user);
        return ResponseEntity.ok().body("{}");
    }

    @PostMapping("/users/connect/{userId}/{wallboxId}")
    public ResponseEntity<String> addWallboxToUser(@RequestParam Long userId, @RequestParam Long wallboxId){
        userService.addWallbox(userId, wallboxId);
        return ResponseEntity.ok().body("{}");
    }


}
