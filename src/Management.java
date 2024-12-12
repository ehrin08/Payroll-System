import java.util.Scanner;

public class Management {
    private EmployeeManager manage;

    public Management(EmployeeManager manager) {
        this.manage = manager;  // Set the manager instance passed from Main
    }

    public void managementScr() {
        Scanner scanner = new Scanner(System.in);
        Misc misc = new Misc();

        // Default employees
        manage.addEmployee(new EmployeePayroll("001", "Aliyah C. Calanoc"));
        manage.addEmployee(new EmployeePayroll("002", "King Andrei D. Carandang"));
        manage.addEmployee(new EmployeePayroll("003", "Rochelle D. Castillo"));
        manage.addEmployee(new EmployeePayroll("004", "Ralph Joedel E. Fonte"));

        String id, name;
        double rate;

        while (true) {
            misc.clearScreen();

            System.out.println("Management");
            System.out.println("[1] Add Employee");
            System.out.println("[2] Delete Employee");
            System.out.println("[3] Check Attendance");
            System.out.println("[4] Show All Attendance Records");
            System.out.println("[5] Generate Payslip");
            System.out.println("[6] Logout");

            System.out.print(" > ");
            char choice = scanner.next().charAt(0);

            scanner.nextLine();

            switch (choice) {
                case '1': // Add employee
                    System.out.print("Enter Employee ID: ");
                    id = scanner.nextLine();

                    System.out.print("Enter Employee Name: ");
                    name = scanner.nextLine();

                    // Adding employee as EmployeePayroll
                    manage.addEmployee(new EmployeePayroll(id, name));
                    misc.pauseScreen();
                    misc.clearScreen();
                    break;

                case '2': // Delete employee thru ID
                    System.out.print("Enter Employee ID to delete: ");
                    id = scanner.nextLine();

                    manage.deleteEmployee(id);
                    misc.pauseScreen();
                    misc.clearScreen();
                    break;

                case '3': // Check attendance
                    System.out.print("Enter Employee ID to check attendance: ");
                    id = scanner.nextLine();

                    Employee employeeAttendance = manage.getEmployeeById(id);

                    if (employeeAttendance != null) {
                        employeeAttendance.checkAttendance(); // Direct method call
                    } else {
                        System.out.println("Employee not found.");
                    }
                    misc.pauseScreen();
                    misc.clearScreen();
                    break;

                case '4': // Show all attendance records
                    System.out.println("Showing attendance for all employees:");
                    for (Employee employee : manage.getAllEmployees()) {
                        employee.checkAttendance();
                    }
                    misc.pauseScreen();
                    misc.clearScreen();
                    break;

                case '5': // Generate and export payslip thru txt file
                    System.out.print("Enter Employee ID to generate payslip: ");
                    id = scanner.nextLine();

                    Employee employeePayslip = manage.getEmployeeById(id);

                    if (employeePayslip != null) {
                        if (employeePayslip instanceof EmployeePayroll) {
                            ((EmployeePayroll) employeePayslip).generatePayslip();
                        } else {
                            System.out.println("Employee not assigned to payroll.");
                        }
                    } else {
                        System.out.println("Employee not found.");
                    }
                    misc.pauseScreen();
                    misc.clearScreen();
                    break;

                case '6':
                    System.out.println("Logging Out...");
                    misc.pauseScreen();
                    misc.clearScreen();

                    return;

                default:
                    System.out.println("Invalid Choice!");
                    misc.pauseScreen();
                    misc.clearScreen();
            }
        }
    }

}
