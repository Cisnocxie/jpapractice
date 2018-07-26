package com.oocl.jpapractice.onetoone.repositories;

import com.oocl.jpapractice.onetoone.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
