package app.service;

import app.entity.Car;
import app.repository.CarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public Car getCarById(Long id){
        return repository.getById(id);
    }

    public List<Car> getAllCars(){
        return repository.findAll();
    }

    public void saveCar(Car car){
        repository.save(car);
    }

    public void deleteCar(Long id){
        repository.deleteById(id);
    }

}
