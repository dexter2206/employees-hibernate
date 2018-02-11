package com.sda.hibernate.employees.prefill;

import com.sda.hibernate.employees.model.Department;
import com.sda.hibernate.employees.model.Employee;
import com.sda.hibernate.employees.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;
import java.util.stream.Stream;

public class PrefillDB {

    private static Project[] projects = new Project[] { new Project("DB migration"), new Project("Recruitment"),
            new Project("Reporting")};

    public static void main(String[] args) {
        Map<String, List<String>> firstNames = createFirstNamesMap();
        Map<String, List<String>> lastNames = createLastNamesMap();
        Map<String, List<Float>> salaries = createSalariesMap();
        try(SessionFactory factory = new Configuration().configure().buildSessionFactory()) {

            try(Session session = factory.openSession()) {
                Arrays.stream(projects).forEach(session::save);
                Stream.of("IT", "Marketing", "Sales")
                        .forEach((deptName) -> addDepartment(session, deptName, firstNames.get(deptName),
                                lastNames.get(deptName), salaries.get(deptName)));
            }
        }
    }

    public static void addDepartment(Session session, String deptName, List<String> firstNames,
                                     List<String> lastNames, List<Float> salaries) {
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            Department dept = new Department(deptName);
            session.save(dept);
            for(int i = 0; i < 3; i++) {
                Employee emp = new Employee(firstNames.get(i), lastNames.get(i), salaries.get(i), dept);
                projects[i].getEmployees().add(emp);
                projects[(i + 1) % 3].getEmployees().add(emp);
                session.save(emp);
            }
            trans.commit();
        } catch(RuntimeException ex) {
            if(trans != null) {
                trans.rollback();
            }
            throw ex;
        }
    }

    private static Map<String, List<String>> createLastNamesMap() {
        Map<String, List<String>> result = new HashMap<>();
        result.put("Marketing", Arrays.asList(new String[]{"Smith", "Williams", "Evans"}));
        result.put("Sales", Arrays.asList(new String[]{"Evans", "Smnith", "Clarke"}));
        result.put("IT", Arrays.asList(new String[]{"Hall", "Green", "Clarke"}));
        return result;
    }

    private static Map<String, List<String>> createFirstNamesMap() {
        Map<String, List<String>> result = new HashMap<>();
        result.put("Marketing", Arrays.asList(new String[]{"John", "Marie", "Genevive"}));
        result.put("Sales", Arrays.asList(new String[]{"Bruce", "Anne", "Mark"}));
        result.put("IT", Arrays.asList(new String[]{"Gordon", "Matt", "Monica"}));
        return result;
    }

    private static Map<String, List<Float>> createSalariesMap() {
        Map<String, List<Float>> result = new HashMap<>();
        result.put("Marketing", Arrays.asList(new Float[]{ 100f, 200f, 110f}));
        result.put("Sales", Arrays.asList(new Float[]{ 200f, 150f, 117f}));
        result.put("IT", Arrays.asList(new Float[]{ 110f, 300f, 200f}));
        return result;
    }
}
