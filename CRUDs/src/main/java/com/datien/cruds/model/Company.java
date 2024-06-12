package com.datien.cruds.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String country;

    @OneToMany(
        mappedBy = "company"
    )
    @JsonManagedReference
    private List<Employee> employees;

    public Company(String name) {
        this.name = name;
    }

    public Company() {

    }
}