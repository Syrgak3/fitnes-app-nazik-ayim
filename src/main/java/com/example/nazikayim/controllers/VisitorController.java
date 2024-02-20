package com.example.nazikayim.controllers;

import com.example.nazikayim.models.Employee;
import com.example.nazikayim.models.Visitor;
import com.example.nazikayim.service.EmployeeService;
import com.example.nazikayim.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @PostMapping
    public ResponseEntity<Visitor> saveEmployee(@RequestBody Visitor visitor) {
        Visitor foundVisitor = visitorService.saveVisitor(visitor);
        if (foundVisitor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundVisitor);
    }

    @PutMapping
    public ResponseEntity<Visitor> editeEmployee(@RequestBody Visitor visitor) {
        Visitor foundVisitor = visitorService.editeVisitor(visitor);
        if (foundVisitor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundVisitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Visitor> deleteEmployee(@PathVariable Long id) {
        visitorService.removeVisitor(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    public ResponseEntity<Visitor> findEmployee(@RequestParam Long id) {
        Visitor visitor = visitorService.findVisitor(id);
        if (visitor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(visitor);
    }

    @GetMapping("/find")
    public ResponseEntity<Visitor> findEmployee(@RequestParam(required = false) String name,
                                                 @RequestParam(required = false) int personalNumber) {
        Visitor foundVisitor;
        if (personalNumber > 0) {
            foundVisitor = visitorService.findVisitor(personalNumber);
        } else if (name != null) {
            foundVisitor = visitorService.findVisitor(name);
        } else {
            return ResponseEntity.badRequest().build();
        }

        if (foundVisitor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundVisitor);
    }
}
