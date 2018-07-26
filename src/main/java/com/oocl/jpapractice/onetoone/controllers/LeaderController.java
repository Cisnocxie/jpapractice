package com.oocl.jpapractice.onetoone.controllers;

import com.oocl.jpapractice.onetoone.entities.Klass;
import com.oocl.jpapractice.onetoone.entities.Leader;
import com.oocl.jpapractice.onetoone.repositories.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leader")
public class LeaderController {

    private LeaderRepository repository;

    @Autowired
    public LeaderController(LeaderRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    public Leader save(@RequestBody Leader leader) {
        return repository.save(leader);
    }

    @GetMapping()
    public List<Leader> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Leader find(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (findAll().stream().filter(leader -> leader.getId() == id).findFirst().orElse(null) != null) {
            repository.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
