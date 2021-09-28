package app.controller;
import app.dto.WallboxSaveDTO;
import app.entity.Wallbox;

import java.util.List;

import app.service.UserService;
import app.service.WallboxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
public class WallboxController {

    @Autowired
    private WallboxService wallboxService;
    @Autowired
    private UserService userService;

    @GetMapping("/wallbox/{wallboxid}")
    public Wallbox findWallboxById(@PathVariable Long wallboxid) {
        return wallboxService.getWallboxById(wallboxid);
    }

    @GetMapping("/wallboxes")
    public List<Wallbox> findAllWallboxes() {
        return wallboxService.getAllWallboxes();
    }

    @PostMapping("/wallboxes/add")
    public ResponseEntity<String> addWallbox(@RequestBody WallboxSaveDTO wallboxSaveDTO) {
        Wallbox wallbox = wallboxSaveDTO.getWallbox();
        log.info(wallbox.getOwner_id() + " " + wallbox.getLatitude()+ " " +wallbox.getLongitude());
        Wallbox savedWallbox = wallboxService.saveWallbox(wallbox);
        log.info(savedWallbox.toString());
        userService.addWallbox(wallboxSaveDTO.getUserId(), savedWallbox.getId());
        return ResponseEntity.ok().body("{}");
    }


}
