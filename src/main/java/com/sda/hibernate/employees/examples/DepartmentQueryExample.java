package com.sda.hibernate.employees.examples;

import com.sda.hibernate.employees.model.Department;
import com.sun.org.apache.xml.internal.security.transforms.implementations.TransformC14NExclusiveWithComments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class DepartmentQueryExample {

    public static void main(String[] args) {
        try(SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            try(Session session = factory.openSession()) {
                List<Department> result = session.createQuery("FROM Department").getResultList();
                result.stream().forEach((dept) -> printDepartment(dept));
            }
        }
    }

    public static void printDepartment(Department dept) {
        System.out.println(dept.getDeptName() + ":");
        dept.getEmployees().stream()
                .map((emp) -> emp.getFirstName() + " " + emp.getLastName() + ", earns: " + emp.getSalary())
                .forEach(System.out::println);
    }
}
