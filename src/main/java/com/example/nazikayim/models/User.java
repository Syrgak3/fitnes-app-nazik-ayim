package com.example.nazikayim.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity{
    private String userName;
    private String password;
}
