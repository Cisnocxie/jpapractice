package com.oocl.jpapractice.onetoone.controllers;

import com.oocl.jpapractice.onetoone.entities.Klass;
import com.oocl.jpapractice.onetoone.repositories.KlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Transactional
    @GetMapping(path = "/{id}")
    public Klass find(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (findAll().stream().filter(klass -> klass.getId() == id).findFirst().orElse(null) != null) {
            repository.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @PutMapping(path = "/{id}")
    public Klass put(@PathVariable int id, @RequestBody Klass klass) {
        List<Klass> klasses = findAll();
        Klass k = klasses.stream().filter(klass1 -> klass1.getId() == id).findFirst().orElse(null);
        if (k != null) {
            klass.setId(id);
            save(klass);
            return klass;
        }
        return null;
    }
}
