package employeebook.skyproemployee;
import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Employee findEmployee(String firstName, String lastName, int department, int salary);

    Employee removeEmployee(String firstName, String lastName, int department, int salary);

    Employee addEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();
}