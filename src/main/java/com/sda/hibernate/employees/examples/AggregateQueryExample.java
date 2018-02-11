package com.sda.hibernate.employees.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AggregateQueryExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = factory.openSession()) {
                Query q = session.createQuery("SELECT dept.deptName, sum(emp.salary) " +
                        "FROM Department dept JOIN dept.employees as emp " +
                        "GROUP BY dept");
                List<Object[]> result = q.getResultList();
                result.stream().map((record) -> record[0] + ": " + record[1]).forEach(System.out::println);
            }
        }
    }
}
