import java.io.FileWriter;
import java.io.IOException;

class EmployeePayroll extends EmployeeAttendance {
    public EmployeePayroll(String id, String name) {
        super(id, name);
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary(); // Salary is calculated based on hours worked in EmployeeAttendance
    }

    public void generatePayslip() {
        displayInfo();
        double grossSalary = calculateSalary();

        // Deductions
        double philhealth = grossSalary * 0.05;
        double sss = grossSalary * 0.045;
        double pagIbig = grossSalary * 0.01;
        double totalDeductions = philhealth + sss + pagIbig;
        double netSalary = grossSalary - totalDeductions;

        System.out.println("Gross Salary: P" + grossSalary);
        System.out.println("Deductions:");
        System.out.println("  PhilHealth: P" + philhealth);
        System.out.println("  SSS       : P" + sss);
        System.out.println("  Pag-IBIG  : P" + pagIbig);
        System.out.println("Net Salary  : P" + netSalary);

        // Export to TXT file
        String fileName = "Payslip_" + getId() + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Payslip\n");
            writer.write("===================\n");
            writer.write("Employee ID: " + getId() + "\n");
            writer.write("Name       : " + getName() + "\n");
            writer.write("Hourly Rate: P" + getRate() + "\n");
            writer.write("Gross Salary: P" + grossSalary + "\n");
            writer.write("Deductions:\n");
            writer.write("  PhilHealth: P" + philhealth + "\n");
            writer.write("  SSS       : P" + sss + "\n");
            writer.write("  Pag-IBIG  : P" + pagIbig + "\n");
            writer.write("Net Salary  : P" + netSalary + "\n");
            System.out.println("Payslip successfully exported to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the payslip: " + e.getMessage());
        }

        // Remove attendance after generating payslip
        clearAttendance();
        System.out.println("Attendance records cleared for " + getName() + ".");
    }

    private void clearAttendance() {
        for (int i = 0; i < 31; i++) {
            attendance[i][0][0] = null;
            attendance[i][0][1] = null;
            attendance[i][1][0] = null;
            attendance[i][1][1] = null;
        }
    }
}
