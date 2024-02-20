package com.example.nazikayim.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Visitor extends BaseEntity{
    private String name;
    private int personalNumber;
}
