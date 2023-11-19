package organization;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Department {
    private String name;

    ArrayList<Employee> employees = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(String name) {
        this.name = name;

    }

    public int totalAmountOfEmployees(ArrayList<Employee> employees) {
        return employees.size();
    }

    public double totalSumOfAllSalaries(ArrayList<Employee> employees) {
        double totalAmount = 0;
        for(Employee em : employees) {
            totalAmount = totalAmount+em.getSalary();
        }
        return totalAmount;
    }

    public Employee findEmployeeByFullName (Employee employee) {
        for (Employee em : employees) {
            if (employee.getName().equals(em.getName()) == true && employee.getSurname().equals(em.getSurname()) == true) {
                employee = em;
            }

        }
        return employee;
    }

    public void fireEmployee(String surname,String name, String jobPosition) {
        Employee employeeToRemove = null;
        for(Employee em : employees) {
            if(em.getName().equals(name) == true && em.getSurname().equals(surname) && em.getJobPosition().equals(jobPosition)) {
                employeeToRemove = em;
                employees.remove(employeeToRemove);
                System.out.println(String.format("The employee with name and job position %s %s,: %s, was removed from employees list",em.getName(),em.getSurname(),em.getJobPosition()));
                break;
            }
        }
        if (employeeToRemove == null) {
            System.out.println("The employee is either not found or the data entered are not correct");
        }
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getSortedEmployees() {
        ArrayList<Employee> sortedEmployees = new ArrayList<>(employees);
        sortedEmployees.sort(Comparator.comparing(Employee::getSurname).thenComparing(Employee::getName));
        return sortedEmployees;
    }
}
