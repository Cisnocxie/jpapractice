package com.oocl.jpapractice.onetomany.repositories;

import com.oocl.jpapractice.onetomany.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
