import java.util.Scanner;

public class Management {
    private EmployeeManager manage;

    public Management(EmployeeManager manager) {
        this.manage = manager;  // Set the manager instance passed from Main
    }

    public void managementScr() {
        Scanner scanner = new Scanner(System.in);
        Misc misc = new Misc();

        String id, name;
        double rate;

        while (true) {
            misc.clearScreen();

            System.out.println("Management");
            System.out.println("[1] Add Employee");
            System.out.println("[2] Delete Employee");
            System.out.println("[3] Check Attendance");
            System.out.println("[4] Generate Payslip");
            System.out.println("[5] Logout");

            System.out.print(" > ");
            char choice = scanner.next().charAt(0);

            scanner.nextLine();

            switch (choice) {
                case '1':
                    System.out.print("Enter Employee ID: ");
                    id = scanner.nextLine();

                    System.out.print("Enter Employee Name: ");
                    name = scanner.nextLine();

                    // Adding employee as EmployeePayroll
                    manage.addEmployee(new EmployeePayroll(id, name));

                    break;

                case '2':
                    System.out.print("Enter Employee ID to delete: ");
                    id = scanner.nextLine();

                    manage.deleteEmployee(id);

                    break;

                case '3':
                    System.out.print("Enter Employee ID to check attendance: ");
                    id = scanner.nextLine();

                    Employee employeeAttendance = manage.getEmployeeById(id);

                    if (employeeAttendance != null) {
                        employeeAttendance.checkAttendance(); // Direct method call
                    } else {
                        System.out.println("Employee not found.");
                    }

                    break;

                case '4':
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

                    break;

                case '5':
                    System.out.println("Logging Out...");
                    misc.clearScreen();

                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
