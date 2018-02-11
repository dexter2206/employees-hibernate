package com.sda.hibernate.employees.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue
    @Column(name="dept_id")
    private Integer deptId;

    @Column(name="dept_name")
    private String deptName;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "department")
    private Set<Employee> employees = new HashSet<>();

    public Department() { }

    public Department(String deptName) {
        this.deptId = null;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
