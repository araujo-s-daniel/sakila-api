package net.sakila.api.service;

import lombok.RequiredArgsConstructor;
import net.sakila.api.entity.City;
import net.sakila.api.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository repository;

    public List<City> findAll() {
        return this.repository.findAll();
    }

    public City save(City newCity) {
        return this.repository.save(newCity);
    }

    public Optional<City> findById(int id) {
        return this.repository.findById(id);
    }

    public void deleteById(int id) {
        this.repository.deleteById(id);
    }
}
