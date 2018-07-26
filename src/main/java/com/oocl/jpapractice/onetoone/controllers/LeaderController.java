package com.oocl.jpapractice.onetoone.controllers;

import com.oocl.jpapractice.onetoone.entities.Klass;
import com.oocl.jpapractice.onetoone.entities.Leader;
import com.oocl.jpapractice.onetoone.repositories.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/leaders")
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

    @Transactional
    @PutMapping(path = "/{id}")
    public Leader put(@PathVariable int id, @RequestBody Leader leader) {
        List<Leader> leaders = findAll();
        if (leaders.stream().filter(leader1 -> leader1.getId() == id).findFirst().orElse(null) != null) {
            leader.setId(id);
            save(leader);
            return leader;
        }
        return null;
    }
}
