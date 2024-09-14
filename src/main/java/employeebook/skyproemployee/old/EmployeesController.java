package employeebook.skyproemployee.old;

import employeebook.skyproemployee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RequestMapping("/employee")
public class EmployeesController {
    private final EmployeesServiceImpl employeesService;

    public EmployeesController(EmployeesServiceImpl employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("department") int department, @RequestParam("salary") int salary) {
        return employeesService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("department") int department, @RequestParam("salary") int salary) {
        return employeesService.findEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("department") int department, @RequestParam("salary") int salary) {
        return employeesService.removeEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("/allEmployees")
    public Collection<Employee> getAllEmployees() {
        return employeesService.getAllEmployees();
    }
}