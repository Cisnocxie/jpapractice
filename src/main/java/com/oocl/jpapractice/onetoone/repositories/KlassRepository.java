package com.oocl.jpapractice.onetoone.repositories;

import com.oocl.jpapractice.onetoone.entities.Klass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlassRepository extends JpaRepository<Klass, Long> {
}
