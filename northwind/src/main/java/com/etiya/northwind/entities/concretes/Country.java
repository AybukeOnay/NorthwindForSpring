package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(mappedBy = "country")
    private List<Customer> customers;

    @OneToMany(mappedBy = "country")
    private List<Employee> employees;

    @OneToMany(mappedBy = "country")
    private List<Supplier> suppliers;
}
