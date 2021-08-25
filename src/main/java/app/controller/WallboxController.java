package app.controller;
import app.entity.Wallbox;

import java.util.List;

import app.service.WallboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WallboxController {

    @Autowired
    private WallboxService wallboxService;

    @GetMapping("/wallbox/{wallboxid}")
    public Wallbox findWallboxById(@PathVariable Long userid) {
        return wallboxService.getWallboxById(userid);
    }

    @GetMapping("/wallboxes")
    public List<Wallbox> findAllWallboxes() {
        return wallboxService.getAllWallboxes();
    }


}
