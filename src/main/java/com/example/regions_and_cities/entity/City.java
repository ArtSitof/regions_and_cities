package com.example.regions_and_cities.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column (name = "year_of_foundation")
    private int yearOfFoundation;

    @Column (name = "population")
    private int population;

    @ManyToOne
    @JoinColumn(name = "region_id"
            , foreignKey = @ForeignKey(name = "city_fk_region"))
    Region region;

}
