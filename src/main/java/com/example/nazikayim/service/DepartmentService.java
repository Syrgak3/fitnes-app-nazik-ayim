package com.example.nazikayim.service;

import com.example.nazikayim.models.Department;
import com.example.nazikayim.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;

    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public Department editeDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public Department findDepartment(Long id) {
        return departmentRepo.findById(id).get();
    }

    public Department findDepartment(String name) {
        return departmentRepo.findByName(name);
    }
}
