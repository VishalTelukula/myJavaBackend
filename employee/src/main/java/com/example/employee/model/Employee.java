package com.example.employee.model;

import jakarta.persistence.*;

@Entity
//marking this as entity calss so that the spring boot understands this as entity calss

@Table(name = "emp_table")

//table is allocated
public class Employee {
    @Id
    // this is id allocates dynamically form 1 to nig numbers


    @GeneratedValue(strategy = GenerationType.AUTO)
    // this will generate ids (the below line)


    private  Long id;             // start variable names as small
    @Column(name = "emp_Salary")
    private   double salary;
    @Column(name = "emp_Name")
    private  String name;
    @Column(name = "emp_Dept")
    private  String dept;

    //basic detalis who is employee
    // id salary name dept

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }



}
