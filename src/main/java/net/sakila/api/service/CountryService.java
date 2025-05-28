package net.sakila.api.service;

import lombok.RequiredArgsConstructor;
import net.sakila.api.entity.Country;
import net.sakila.api.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository repository;

    public List<Country> findAll() {
        return this.repository.findAll();
    }

    public Country save(Country newCountry) {
        return this.repository.save(newCountry);
    }

    public Optional<Country> findById(int id) {
        return this.repository.findById(id);
    }

    public void deleteById(int id) {
        this.repository.deleteById(id);
    }
}
