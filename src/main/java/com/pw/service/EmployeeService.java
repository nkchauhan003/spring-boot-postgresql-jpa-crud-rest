package com.pw.service;

import com.pw.model.Employee;
import com.pw.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService implements CrudService<Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee retrieve(int id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Employee with id: " + id + ", not available."));
    }

    @Override
    public Employee update(Employee employee) {
        Employee employeeDb = employeeRepository.findById(employee.getId()).orElseThrow(
                () -> new EntityNotFoundException("Employee with id: " + employee.getId() + ", not available."));

        employeeDb.setName(employee.getName());
        employeeDb.setDesignation(employee.getDesignation());

        return employeeRepository.save(employeeDb);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
