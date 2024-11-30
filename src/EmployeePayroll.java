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
        double salary = calculateSalary();
        System.out.println("Total Salary for the month: P" + salary);
    }
}
