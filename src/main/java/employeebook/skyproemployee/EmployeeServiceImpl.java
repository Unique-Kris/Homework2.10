package employeebook.skyproemployee;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.springframework.util.StringUtils.capitalize;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan", "Ivanov", 1, 20000),
            new Employee("Oleg", "Ivanov", 2, 25000),
            new Employee("Ivan", "Fedorov", 1, 23000),
            new Employee("Oleg", "Fedorov", 3, 27000),
            new Employee("Ivan", "Sidorov", 1, 30000),
            new Employee("Oleg", "Sidorov", 3, 24000),
            new Employee("Ivan", "Petrenko", 2, 26000),
            new Employee("Oleg", "Petrenko", 2, 31000),
            new Employee("Roman", "Polyakov", 3, 19000),
            new Employee("Gennadiy", "Polyakov", 2, 32000)
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        validateNames(firstName, lastName);

        Employee employee = new Employee(capitalize(firstName), capitalize(lastName), department, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeWithMinSalaryOfDepartment(int department) {
        return this.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeDepartmentNotFoundException("Отдел не найден"));
    }

    @Override
    public Employee getEmployeeWithMaxSalaryOfDepartment(int department) {
        return this.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeDepartmentNotFoundException("Отдел не найден"));
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees);
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return this.findAll().stream()
                .collect(groupingBy(Employee::getDepartment));
    }

    @Override
    public Collection<Employee> getDepartmentEmployees(int department) {
        return this.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getDepartmentEmployeesMap() {
        return Map.of();
    }

    private void validateNames(String... names) {
        for (String name : names) {
            if (!isAlpha(name)) {
                throw new InvalidNameException(name);
            }
        }
    }
}