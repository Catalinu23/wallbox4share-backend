package app.controller;

import app.entity.Car;

import java.util.List;

import app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car/{carid}")
    public Car findCarById(@PathVariable Long userid) {return carService.getCarById(userid);
    }

    @GetMapping("/cars")
    public List<Car> findAllCars() {
        return carService.getAllCars();
    }


}
