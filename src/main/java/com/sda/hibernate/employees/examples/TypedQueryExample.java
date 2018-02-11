package com.sda.hibernate.employees.examples;

import com.sda.hibernate.employees.model.DepartmentSalary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TypedQueryExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = factory.openSession()) {

                Query <DepartmentSalary> q = session.createQuery("SELECT new com.sda.hibernate.employees.model.DepartmentSalary(dept.deptName, sum(emp.salary)) " +
                        "FROM Department dept JOIN dept.employees as emp " +
                        "GROUP BY dept");

                q.getResultList().stream()
                        .map((record) -> record.getDeptName() + ": " + record.getTotalSalary())
                        .forEach(System.out::println);
            }
        }
    }
}
