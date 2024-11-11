package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vishaltelukula/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeSerivce;
    //  get mapping   post mappping   put mapping   delete mapping
    @GetMapping
    public List<Employee>getallEmployees(){
        return employeeSerivce.getAllEmployee();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
       // return employeeSerivce.getEmployeeById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        return employeeSerivce.getEmployeeById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeSerivce.createEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeSerivce.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping ("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee fobj){
        try {
            return ResponseEntity.ok(employeeSerivce.updateEmployee(id,fobj));
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }

    }

}
