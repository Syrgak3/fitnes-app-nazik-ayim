package com.example.nazikayim.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Department extends BaseEntity{
    private String name;
    @OneToMany
    private List<Employee> employees;
}
