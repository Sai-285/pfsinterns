import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    public void addEmplyee(String name, double hourlyRate, double taxRate) {
        Employee employee = new Employee(nextId++, name, hourlyRate, taxRate);
        employees.add(employee);
    }

    public Employee getEmployeeById(int id) {
        for(Employee employee : employees) {
            if(employee.getEmployeeID() == id) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
