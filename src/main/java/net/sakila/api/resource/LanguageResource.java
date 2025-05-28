package net.sakila.api.resource;

import lombok.RequiredArgsConstructor;
import net.sakila.api.entity.Language;
import net.sakila.api.resource.exception.NotFoundException;
import net.sakila.api.service.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/languages")
public class LanguageResource {

    private final LanguageService service;

    @GetMapping
    List<Language> findAllLanguages() {
        return this.service.findAll();
    }

    @PostMapping
    Language newLanguage(@RequestBody Language newLanguage) {
        return this.service.save(newLanguage);
    }

    @GetMapping("/{id}")
    Language findLanguageById(@PathVariable int id) {
        return this.service.findById(id)
                .orElseThrow(() -> new NotFoundException("language", id));
    }

    @PutMapping("/{id}")
    Language updateLanguage(@RequestBody Language newLanguage, @PathVariable int id) {
        return this.service.findById(id)
                .map(language -> {
                    language.setName(newLanguage.getName());
                    language.setLastUpdate(newLanguage.getLastUpdate());
                    return this.service.save(language);
                })
                .orElseGet(() -> this.service.save(newLanguage));
    }

    @DeleteMapping("/{id}")
    void deleteLanguage(@PathVariable int id) {
        this.service.deleteById(id);
    }
}
