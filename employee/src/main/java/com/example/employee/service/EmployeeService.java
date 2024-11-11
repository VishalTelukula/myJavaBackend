package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    //what this does is injects all the constructor,methods into this service class
    private EmployeeRepository employeeRepository;
    //created an employeerepository object instance
    //to use jpa methods we have to crete an instance of the repository
    // c create r retrive u upddate d delete


    // lets start with retrive by retriving a list of parameters

    public List<Employee>getAllEmployee(){
        return employeeRepository.findAll();

    }//this is called generics
    public Optional<Employee>getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);

    }
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
        System.out.println("deleted");
    }
    public Employee updateEmployee(Long id,Employee fobj){
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(fobj.getName());
                    employee.setDept(fobj.getDept());
                    employee.setSalary(fobj.getSalary());
                    return employeeRepository.save(employee);
                }).orElseThrow(() -> new RuntimeException("employee not found"));
    }
}