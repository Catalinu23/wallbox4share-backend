package app.controller;
import app.entity.Wallbox;

import java.util.List;

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

    @GetMapping("/wallbox/{wallboxid}")
    public Wallbox findWallboxById(@PathVariable Long wallboxid) {
        return wallboxService.getWallboxById(wallboxid);
    }

    @GetMapping("/wallboxes")
    public List<Wallbox> findAllWallboxes() {
        return wallboxService.getAllWallboxes();
    }

    @PostMapping("/wallboxes/add")
    public ResponseEntity<String> addWallbox(@RequestBody Wallbox wallbox) {
        log.info(wallbox.getOwner_name() + " " + wallbox.getLatitude()+ " " +wallbox.getLongitude());
        wallboxService.saveWallbox(wallbox);
        return ResponseEntity.ok().body("{}");
    }


}
