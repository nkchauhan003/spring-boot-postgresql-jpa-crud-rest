package com.pw.controller;

import com.pw.model.Employee;
import com.pw.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/article")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private CrudService<Employee> employeeCrudService;

    @PostMapping(value = "/", consumes = "application/json")
    public Employee create(@RequestBody Employee employee) {
        return employeeCrudService.create(employee);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Employee retrieve(@PathVariable int id) {
        return employeeCrudService.retrieve(id);
    }

    @PutMapping(value = "/", consumes = "application/json")
    public Employee update(@RequestBody Employee employee) {
        return employeeCrudService.update(employee);
    }

    @DeleteMapping(value = "/")
    public String delete(int id) {
        employeeCrudService.delete(id);
        return "Done";
    }
}
