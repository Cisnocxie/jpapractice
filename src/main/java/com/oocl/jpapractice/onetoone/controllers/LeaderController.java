package com.oocl.jpapractice.onetoone.controllers;

import com.oocl.jpapractice.onetoone.entities.Klass;
import com.oocl.jpapractice.onetoone.entities.Leader;
import com.oocl.jpapractice.onetoone.repositories.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
