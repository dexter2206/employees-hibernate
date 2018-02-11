package com.sda.hibernate.employees.examples;

import com.sda.hibernate.employees.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeQueryExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = factory.openSession()) {
                Query q = session.createQuery("FROM Employee");
                List<Employee> result = q.getResultList();
                result.stream().map((emp) -> emp.getFirstName() + " " + emp.getLastName() + " " + emp.getDepartment().getDeptName()).forEach(System.out::println);
            }
        }
    }
}
