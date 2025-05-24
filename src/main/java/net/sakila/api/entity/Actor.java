package net.sakila.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int id;

    private String firstName;
    private String lastName;
    private ZonedDateTime lastUpdate = ZonedDateTime.now();
}
