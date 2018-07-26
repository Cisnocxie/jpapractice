package com.oocl.jpapractice.onetoone.repositories;

import com.oocl.jpapractice.onetoone.entities.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderRepository extends JpaRepository<Leader, Integer> {
}
