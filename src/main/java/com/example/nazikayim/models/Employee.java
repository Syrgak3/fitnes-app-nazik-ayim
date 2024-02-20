package com.example.nazikayim.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends BaseEntity{
    private String name;
    private int personalNumber;
    @ManyToOne
    private Department department;
}
