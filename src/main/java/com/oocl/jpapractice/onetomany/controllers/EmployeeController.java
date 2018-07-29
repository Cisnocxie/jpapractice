package com.oocl.jpapractice.onetomany.controllers;

import com.oocl.jpapractice.onetomany.entities.Employee;
import com.oocl.jpapractice.onetomany.repositories.CompanyRepository;
import com.oocl.jpapractice.onetomany.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    @Transactional
    @PostMapping("")
    public Employee save(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @GetMapping("")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    @GetMapping("/{id}")
    public Employee find(@PathVariable long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElse(null);
        if (employee1 != null) {
            employee1.setCompany(employee.getCompany());
            employee1.setName(employee.getName());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public Employee delete(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employeeRepository.delete(employee);
        }
        return employee;
    }
}
