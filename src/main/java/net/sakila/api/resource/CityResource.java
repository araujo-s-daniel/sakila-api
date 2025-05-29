package net.sakila.api.resource;

import lombok.RequiredArgsConstructor;
import net.sakila.api.entity.City;
import net.sakila.api.resource.exception.NotFoundException;
import net.sakila.api.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityResource {

    private final CityService service;

    @GetMapping
    List<City> findAllCities() {
        return this.service.findAll();
    }

    @PostMapping
    City newCity(@RequestBody City newCity) {
        return this.service.save(newCity);
    }

    @GetMapping("/{id}")
    City findCityById(@PathVariable int id) {
        return this.service.findById(id)
                .orElseThrow(() -> new NotFoundException("city", id));
    }

    @PutMapping("/{id}")
    City updateCity(@RequestBody City newCity, @PathVariable int id) {
        return this.service.findById(id)
                .map(city -> {
                    city.setName(newCity.getName());
                    city.setCountry(newCity.getCountry());
                    city.setLastUpdate(newCity.getLastUpdate());
                    return this.service.save(city);
                })
                .orElseGet(() -> this.service.save(newCity));
    }

    @DeleteMapping("/{id}")
    void deleteCity(@PathVariable int id) {
        this.service.deleteById(id);
    }
}
