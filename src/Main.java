import organization.Department;
import organization.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Менеджер", 35000.0, "Иван", "Иванов");
        Employee employee2 = new Employee("Инженер", 40000.0, "Петр", "Петров");


        Department department = new Department("Отдел разработки");

        department.hireEmployee(employee1);
        department.hireEmployee(employee2);

        System.out.println("Сотрудники отдела до изменений:");
        List<Employee> departmentEmployees = department.getSortedEmployees();
        for (Employee employee : departmentEmployees) {
            System.out.println(employee.getName() + " " + employee.getSurname() +
                    ", " + employee.getJobPosition() + ", Зарплата: " + employee.getSalary());
        }

        Employee newEmployee = new Employee("Дизайнер", 30000.0, "Anna", "Sidorova");
        department.hireEmployee(newEmployee);

        System.out.println("\nСотрудники отдела после приема нового сотрудника:");
        departmentEmployees = department.getSortedEmployees();
        for (Employee employee : departmentEmployees) {
            System.out.println(employee.getName() + " " + employee.getSurname() +
                    ", " + employee.getJobPosition() + ", Зарплата: " + employee.getSalary());
        }

        department.fireEmployee("Иванов", "Иван", "Менеджер");

        System.out.println("\nСотрудники отдела после увольнения сотрудника:");
        departmentEmployees = department.getSortedEmployees();
        for (Employee employee : departmentEmployees) {
            System.out.println(employee.getName() + " " + employee.getSurname() +
                    ", " + employee.getJobPosition() + ", Зарплата: " + employee.getSalary());
        }
    }
    }
