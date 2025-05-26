package net.sakila.api.service;

import lombok.RequiredArgsConstructor;
import net.sakila.api.entity.Category;
import net.sakila.api.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> findAll() {
        return this.repository.findAll();
    }

    public Category save(Category newCategory) {
        return this.repository.save(newCategory);
    }

    public Optional<Category> findById(int id) {
        return this.repository.findById(id);
    }

    public void deleteById(int id) {
        this.repository.deleteById(id);
    }
}
