package net.sakila.api.resource;

import lombok.RequiredArgsConstructor;
import net.sakila.api.entity.Country;
import net.sakila.api.resource.exception.NotFoundException;
import net.sakila.api.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryResource {

    private final CountryService service;

    @GetMapping
    List<Country> findAllCountries() {
        return this.service.findAll();
    }

    @PostMapping
    Country newCountry(@RequestBody Country newCountry) {
        return this.service.save(newCountry);
    }

    @GetMapping("/{id}")
    Country findCountryById(@PathVariable int id) {
        return this.service.findById(id)
                .orElseThrow(() -> new NotFoundException("country", id));
    }

    @PutMapping("/{id}")
    Country updateCountry(@RequestBody Country newCountry, @PathVariable int id) {
        return this.service.findById(id)
                .map(country -> {
                    country.setName(newCountry.getName());
                    country.setLastUpdate(newCountry.getLastUpdate());
                    return this.service.save(country);
                })
                .orElseGet(() -> this.service.save(newCountry));
    }

    @DeleteMapping("/{id}")
    void deleteCountry(@PathVariable int id) {
        this.service.deleteById(id);
    }
}
