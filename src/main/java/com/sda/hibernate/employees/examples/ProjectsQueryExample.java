package com.sda.hibernate.employees.examples;

import com.sda.hibernate.employees.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ProjectsQueryExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = factory.openSession()) {
                Query<Project> q = session.createQuery("FROM Project");
                q.getResultList().forEach(ProjectsQueryExample::printProject);
            }
        }
    }

    private static void printProject(Project project) {
        System.out.println("Employees engaged in project: " + project.getProjName());
        project.getEmployees().stream()
                .map((emp) -> (emp.getFirstName() + " " + emp.getLastName() + " from " +
                        emp.getDepartment().getDeptName()))
                .forEach(System.out::println);
    }
}
