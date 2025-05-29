package net.sakila.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;

    @Column(name = "city")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private ZonedDateTime lastUpdate = ZonedDateTime.now();
}
