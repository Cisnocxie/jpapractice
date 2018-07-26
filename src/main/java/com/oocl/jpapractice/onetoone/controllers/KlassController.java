package com.oocl.jpapractice.onetoone.controllers;

import com.oocl.jpapractice.onetoone.entities.Klass;
import com.oocl.jpapractice.onetoone.repositories.KlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/klass")
public class KlassController {

    private KlassRepository repository;

    @Autowired
    public KlassController(KlassRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping(path = "")
    public Klass save(@RequestBody Klass klass) {
        return repository.save(klass);
    }

    
}
