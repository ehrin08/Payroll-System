import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();

    // Add an employee to the system
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    // Delete an employee by ID
    public void deleteEmployee(String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                System.out.println("Employee removed: " + employees.get(i).getName());
                employees.remove(i);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // Get employee by ID
    public Employee getEmployeeById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }
}