package com.example.nazikayim.service;

import com.example.nazikayim.models.Employee;
import com.example.nazikayim.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee editeEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployee(Long id) {
        return employeeRepo.findById(id).get();
    }

    public Employee findEmployee(String name) {
        return employeeRepo.findByName(name);
    }

    public Employee findEmployee(int personalNumber) {
        return employeeRepo.findByPersonalNumber(personalNumber);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

}
