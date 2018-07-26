package com.oocl.jpapractice.onetoone.repositories;

import com.oocl.jpapractice.onetoone.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
