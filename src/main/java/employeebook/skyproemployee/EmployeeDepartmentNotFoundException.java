package employeebook.skyproemployee;

public class EmployeeDepartmentNotFoundException extends RuntimeException{
    public EmployeeDepartmentNotFoundException(String message) {
        super(message);
    }
}