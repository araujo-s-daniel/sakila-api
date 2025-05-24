package net.sakila.api.resource;

import lombok.RequiredArgsConstructor;
import net.sakila.api.entity.Actor;
import net.sakila.api.resource.exception.NotFoundException;
import net.sakila.api.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorResource {

    private final ActorService service;

    @GetMapping
    List<Actor> findAllActors() {
        return this.service.findAll();
    }

    @PostMapping
    Actor newActor(@RequestBody Actor newActor) {
        return this.service.save(newActor);
    }

    @GetMapping("/{id}")
    Actor findActorById(@PathVariable int id) {
        return this.service.findById(id)
                .orElseThrow(() -> new NotFoundException("actor", id));
    }

    @PutMapping("/{id}")
    Actor updateActor(@RequestBody Actor newActor, @PathVariable int id) {
        return this.service.findById(id)
                .map(actor -> {
                    actor.setFirstName(newActor.getFirstName());
                    actor.setLastName(newActor.getLastName());
                    actor.setLastUpdate(newActor.getLastUpdate());
                    return this.service.save(actor);
                })
                .orElseGet(() -> this.service.save(newActor));
    }

    @DeleteMapping("/{id}")
    void deleteActor(@PathVariable int id) {
        this.service.deleteById(id);
    }
}
