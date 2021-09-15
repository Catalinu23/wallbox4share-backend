package app.service;

import app.entity.User;
import app.entity.Wallbox;
import app.repository.UserRepository;
import java.util.List;

import app.repository.WallboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WallboxService {

    @Autowired
    private WallboxRepository repository;

    public Wallbox getWallboxById(Long id){
        return repository.getById(id);
    }

    public List<Wallbox> getAllWallboxes(){
        return repository.findAll();
    }

    public Wallbox saveWallbox(Wallbox wallbox){
        return repository.save(wallbox);
    }

    public void deleteWallbox(Long id){
        repository.deleteById(id);
    }

}
