package com.oocl.jpapractice.onetoone.controllers;

import com.oocl.jpapractice.onetoone.entities.Klass;
import com.oocl.jpapractice.onetoone.repositories.KlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/klass")
public class KlassController {

    private KlassRepository repository;

    @Autowired
    public KlassController(KlassRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping()
    public Klass save(@RequestBody Klass klass) {
        return repository.save(klass);
    }

    @Transactional
    @GetMapping()
    public List<Klass> findAll() {
        return repository.findAll();
    }
}
