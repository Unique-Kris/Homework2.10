package employeebook.skyproemployee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Employee getEmployeeWithMinSalaryOfDepartment(int department);

    Employee getEmployeeWithMaxSalaryOfDepartment(int department);

    Collection<Employee> findAll();

    Map<Integer, List<Employee>> getAllEmployees();

    Collection<Employee> getDepartmentEmployees(int department);

    Map<Integer, List<Employee>> getDepartmentEmployeesMap();
}