package app.controller;

import app.entity.User;

import java.net.URI;
import java.util.List;

import app.entity.Wallbox;
import app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        log.info("id:" + user.getId() + " " + user.getEmail() + " " + user.getUsername() + " " + user.getPassword());
        if(createdUser != null) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(uri).body(createdUser);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/users/connect/{userId}/{wallboxId}")
    public ResponseEntity<String> addWallboxToUser(@RequestParam Long userId, @RequestParam Long wallboxId){
        userService.addWallbox(userId, wallboxId);
        return ResponseEntity.ok().body("{}");
    }


}
