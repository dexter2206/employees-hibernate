package com.sda.hibernate.employees.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="emp_id")
    private Integer empId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="salary")
    private Float salary;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dept_id")
    private Department department;

    @ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();

    public Employee() { }

    public Employee(String firstName, String lastName, Float salary, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
