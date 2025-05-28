package net.sakila.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int id;

    private String name;
    private ZonedDateTime lastUpdate = ZonedDateTime.now();
}
