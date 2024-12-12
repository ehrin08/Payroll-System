import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Input
        // Creating instances of EmployeeManager, Management, and Misc
        EmployeeManager manager = new EmployeeManager();
        Management management = new Management(manager);  // Pass the manager here
        Misc misc = new Misc();

        String id, passcode = "1";

        while (true) {
            System.out.println("\nEmployee Attendance Management and Payroll System");
            System.out.println("[1] Check-In");
            System.out.println("[2] Check-Out");
            System.out.println("[3] Management");

            System.out.print(" > ");
            char choice = scanner.next().charAt(0);

            scanner.nextLine(); // For auto scan error

            switch (choice) {
                case '1': // Time in
                    System.out.print("Enter Employee ID to mark Time In: ");
                    id = scanner.nextLine();

                    Employee employeeIn = manager.getEmployeeById(id);

                    if (employeeIn != null) {
                        employeeIn.markTimeIn(); // Direct method call
                    } else {
                        System.out.println("Employee not found.");
                    }

                    misc.pauseScreen();
                    misc.clearScreen();
                    break;

                case '2': // Time out
                    System.out.print("Enter Employee ID to mark Time Out: ");
                    id = scanner.nextLine();

                    Employee employeeOut = manager.getEmployeeById(id);

                    if (employeeOut != null) {
                        employeeOut.markTimeOut(); // Direct method call
                    } else {
                        System.out.println("Employee not found.");
                    }

                    misc.pauseScreen();
                    misc.clearScreen();
                    break;

                case '3': // Go to management
                    System.out.print("Please enter passcode: ");
                    passcode = scanner.nextLine();

                    if (passcode.equals("admin")) {
                        management.managementScr();  // Management now uses the same manager instance
                    } else {
                        System.out.println("Incorrect Passcode!");
                    }

                    misc.pauseScreen();
                    misc.clearScreen();
                    break;

                default:

                    System.out.println("Invalid Choice!");
                    misc.pauseScreen();
                    misc.clearScreen();
            }
        }
    }
}
