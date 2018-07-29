package com.oocl.jpapractice.onetomany.repositories;

import com.oocl.jpapractice.onetomany.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
