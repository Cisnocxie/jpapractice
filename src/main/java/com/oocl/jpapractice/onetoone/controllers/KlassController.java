package com.oocl.jpapractice.onetoone.controllers;

import com.oocl.jpapractice.onetoone.entities.Klass;
import com.oocl.jpapractice.onetoone.entities.Leader;
import com.oocl.jpapractice.onetoone.repositories.KlassRepository;
import com.oocl.jpapractice.onetoone.repositories.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/klasses")
public class KlassController {

    private KlassRepository repository;
    private LeaderRepository leaderRepository;

    @Autowired
    public KlassController(KlassRepository repository, LeaderRepository leaderRepository) {
        this.repository = repository;
        this.leaderRepository = leaderRepository;
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
        if (repository.findById(id).orElse(null) != null) {
            repository.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @PutMapping(path = "/{id}")
    public Klass put(@PathVariable int id, @RequestBody Klass klass) {
        Klass k = repository.findById(id).orElse(null);
        if (k != null) {
            klass.setId(id);
            repository.save(klass);
            return klass;
        }
        return null;
    }

    @Transactional
    @PatchMapping(path = "/{id}")
    public Klass patch(@PathVariable int id, @RequestBody Leader leader) {
        Klass klass = repository.findById(id).orElse(null);
        Leader leader1 = leaderRepository.findById(leader.getId()).orElse(null);
        if (klass != null) {
            klass.setLeader(leader1);
            repository.save(klass);

            if (leader1 != null) {
                leader1.setKlass(klass);
                leaderRepository.save(leader1);
            } else {
                leader.setKlass(klass);
                leaderRepository.save(leader);
            }
            return klass;
        }
        return null;
    }
}
