package com.example.nazikayim.controllers;

import com.example.nazikayim.models.Employee;
import com.example.nazikayim.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee foundEmployee = employeeService.saveEmployee(employee);
        if (foundEmployee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundEmployee);
    }

    @PutMapping
    public ResponseEntity<Employee> editeEmployee(@RequestBody Employee employee) {
        Employee foundEmployee = employeeService.editeEmployee(employee);
        if (foundEmployee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    public ResponseEntity<Employee> findEmployee(@RequestParam Long id) {
        Employee employee = employeeService.findEmployee(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/find")
    public ResponseEntity<Employee> findEmployee(@RequestParam(required = false) String name,
                                                 @RequestParam(required = false) int personalNumber) {
        Employee foundEmployee;
        if (personalNumber > 0) {
            foundEmployee = employeeService.findEmployee(personalNumber);
        } else if (name != null) {
            foundEmployee = employeeService.findEmployee(name);
        } else {
            return ResponseEntity.badRequest().build();
        }

        if (foundEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(foundEmployee);
    }
}
