class Payroll {
    private Employee[] employees;
    private int capacity;
    private int size;

    public Payroll(int capacity) {
        this.capacity = capacity;
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < capacity) {
            employees[size] = employee;
            size++;
        }
    }

    public void printPayroll() {
        System.out.println("Payroll:");
        for (int i = 0; i < size; i++) {
            System.out.printf("\nEmployee ID: " + employees[i].employeeId + " , Name: " + employees[i].name +" , Salary: " + employees[i].calculateSalary());
        }
    }
}