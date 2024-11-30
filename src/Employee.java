abstract class Employee {
    private String id;
    private String name;
    private double rate = 65; // Fixed hourly rate

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate; // Always return fixed rate
    }

    public abstract double calculateSalary(); // Abstract method for salary calculation

    public void displayInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name       : " + name);
        System.out.println("Hourly Rate: P" + rate);
    }

    // Abstract method to mark time in (to be implemented by subclasses)
    public abstract void markTimeIn();

    // Abstract method to mark time out (to be implemented by subclasses)
    public abstract void markTimeOut();

    // Abstract method to check attendance (to be implemented by subclasses)
    public abstract void checkAttendance();
}
