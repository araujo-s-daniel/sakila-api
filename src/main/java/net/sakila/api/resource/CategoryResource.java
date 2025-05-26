package net.sakila.api.resource;

import lombok.RequiredArgsConstructor;
import net.sakila.api.entity.Category;
import net.sakila.api.resource.exception.NotFoundException;
import net.sakila.api.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryResource {

    private final CategoryService service;

    @GetMapping
    List<Category> findAllCategories() {
        return this.service.findAll();
    }

    @PostMapping
    Category newCategory(@RequestBody Category newCategory) {
        return this.service.save(newCategory);
    }

    @GetMapping("/{id}")
    Category findCategoryById(@PathVariable int id) {
        return this.service.findById(id)
                .orElseThrow(() -> new NotFoundException("category", id));
    }

    @PutMapping("/{id}")
    Category updateCategory(@RequestBody Category newCategory, @PathVariable int id) {
        return this.service.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    category.setLastUpdate(newCategory.getLastUpdate());
                    return this.service.save(category);
                })
                .orElseGet(() -> this.service.save(newCategory));
    }

    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable int id) {
        this.service.deleteById(id);
    }
}
