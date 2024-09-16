package employeebook.skyproemployee.old;

import employeebook.skyproemployee.Employee;

import java.util.Collection;

public interface EmployeesService {

    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Employee findEmployee(String firstName, String lastName, int department, int salary);

    Employee removeEmployee(String firstName, String lastName, int department, int salary);

    Collection<Employee> getAllEmployees();
}