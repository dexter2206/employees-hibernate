package com.sda.hibernate.employees.examples;

import com.sda.hibernate.employees.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TopEarnerQueryExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = factory.openSession()) {
                Query<Employee> q2 = session.createQuery("SELECT emp1 FROM Employee emp1 " +
                        "WHERE emp1.salary = (SELECT max(emp2.salary) FROM Department dept JOIN dept.employees emp2 " +
                        "WHERE dept = emp1.department)");
                q2.getResultList().stream().map((emp) -> emp.getFirstName() + " " + emp.getLastName())
                        .forEach(System.out::println);
            }
        }
    }
}
