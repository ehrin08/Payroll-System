
public class Main {
    public static void main(String[] args) {
        // Create Payroll and Attendance with a capacity of 10 employees
        Payroll payroll = new Payroll(10);
        Attendance attendance = new Attendance(10);

        // Create employees
        Employee emp1 = new FullTimeEmployee("John", "F001", 5000);
        Employee emp2 = new PartTimeEmployee("Doe", "P001", 65, 45);

        // Add employees to payroll
        payroll.addEmployee(emp1);
        payroll.addEmployee(emp2);

        // Mark attendance
        attendance.markAttendance(emp1.employeeId, "2023-10-01");
        attendance.markAttendance(emp1.employeeId, "2023-10-02");
        attendance.markAttendance(emp2.employeeId, "2023-10-01");

        // Print payroll
        payroll.printPayroll();

        // Print attendance
        System.out.println("\nAttendance Records:");
        System.out.println("Alice's Attendance: ");
        for (String date : attendance.getAttendance(emp1.employeeId)) {
            System.out.println(date);
        }
        System.out.println("Bob's Attendance: ");
        for (String date : attendance.getAttendance(emp2 .employeeId)) {
            System.out.println(date);
        }
    }

}