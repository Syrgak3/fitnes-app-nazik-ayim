package com.example.nazikayim.repository;

import com.example.nazikayim.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);

    Employee findByPersonalNumber(int personalNumber);
}
