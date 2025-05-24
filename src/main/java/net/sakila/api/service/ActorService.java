package net.sakila.api.service;

import lombok.RequiredArgsConstructor;
import net.sakila.api.entity.Actor;
import net.sakila.api.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository repository;

    public List<Actor> findAll() {
        return this.repository.findAll();
    }

    public Actor save(Actor newActor) {
        return this.repository.save(newActor);
    }

    public Optional<Actor> findById(int id) {
        return this.repository.findById(id);
    }

    public void deleteById(int id) {
        this.repository.deleteById(id);
    }
}
