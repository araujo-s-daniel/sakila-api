package net.sakila.api.service;

import lombok.RequiredArgsConstructor;
import net.sakila.api.entity.Language;
import net.sakila.api.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository repository;

    public List<Language> findAll() {
        return this.repository.findAll();
    }

    public Language save(Language newLanguage) {
        return this.repository.save(newLanguage);
    }

    public Optional<Language> findById(int id) {
        return this.repository.findById(id);
    }

    public void deleteById(int id) {
        this.repository.deleteById(id);
    }
}
