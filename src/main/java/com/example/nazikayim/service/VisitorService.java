package com.example.nazikayim.service;

import com.example.nazikayim.models.Visitor;
import com.example.nazikayim.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepo;

    public Visitor saveVisitor(Visitor visitor) {
        return visitorRepo.save(visitor);
    }

    public Visitor editeVisitor(Visitor visitor) {
        return visitorRepo.save(visitor);
    }

    public Visitor findVisitor(Long id) {
        return visitorRepo.findById(id).get();
    }

    public Visitor findVisitor(String name) {
        return visitorRepo.findByName(name);
    }

    public Visitor findVisitor(int personalNumber) {
        return visitorRepo.findByPersonalNumber(personalNumber);
    }

    public void removeVisitor(Long id) {
        visitorRepo.deleteById(id);
    }
}
