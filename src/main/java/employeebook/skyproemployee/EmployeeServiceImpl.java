package employeebook.skyproemployee;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}