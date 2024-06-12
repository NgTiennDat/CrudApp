package com.datien.cruds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstname;
    private String lastname;
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private String phone;

    @ManyToOne
    @JoinColumn(
            name = "company_id"
    )
    @JsonBackReference
    private Company company;

    public Employee() {

    }

    public Employee(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
}
