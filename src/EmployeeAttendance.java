import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class EmployeeAttendance extends Employee {
    String[][][] attendance; // [Day][TimeIn/Out][HH/MM]

    public EmployeeAttendance(String id, String name) {
        super(id, name);
        this.attendance = new String[31][2][2]; // For 31 days (Time In and Time Out for each day)
    }

    @Override
    public void markTimeIn() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        int day = date.getDayOfMonth();
        int hour = time.getHour();
        int minute = time.getMinute();

        if (attendance[day - 1][0][0] == null) {
            attendance[day - 1][0][0] = String.valueOf(hour);
            attendance[day - 1][0][1] = String.valueOf(minute);
            System.out.println("Time In for " + getName() + " on " + date.format(DateTimeFormatter.ofPattern("MMMM d")) + " at " + hour + ":" + minute);
        } else {
            System.out.println("Time In already marked for " + getName() + " on " + date.format(DateTimeFormatter.ofPattern("MMMM d")));
        }
    }

    @Override
    public void markTimeOut() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        int day = date.getDayOfMonth();
        int hour = time.getHour();
        int minute = time.getMinute();

        if (attendance[day - 1][0][0] == null) {
            System.out.println("Time In not marked for " + getName() + " on " + date.format(DateTimeFormatter.ofPattern("MMMM d")) + ". Cannot mark Time Out.");
        } else if (attendance[day - 1][1][0] == null) {
            attendance[day - 1][1][0] = String.valueOf(hour);
            attendance[day - 1][1][1] = String.valueOf(minute);
            System.out.println("Time Out for " + getName() + " on " + date.format(DateTimeFormatter.ofPattern("MMMM d")) + " at " + hour + ":" + minute);
        } else {
            System.out.println("Time Out already marked for " + getName() + " on " + date.format(DateTimeFormatter.ofPattern("MMMM d")));
        }
    }

    @Override
    public void checkAttendance() {
        System.out.println("\nAttendance for " + getName() + ":");
        for (int day = 0; day < 31; day++) {
            if (attendance[day][0][0] != null) {
                String timeIn = attendance[day][0][0] + ":" + attendance[day][0][1];
                String timeOut = attendance[day][1][0] == null ? "Not Marked" : attendance[day][1][0] + ":" + attendance[day][1][1];
                LocalDate date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), day + 1);
                System.out.println(date.format(DateTimeFormatter.ofPattern("MMMM d")) + " - Time In: " + timeIn + ", Time Out: " + timeOut);
            }
        }
    }

    @Override
    public double calculateSalary() {
        int totalHoursWorked = 0;
        // Calculate total hours worked for the month (31 days)
        for (int i = 0; i < 31; i++) {
            totalHoursWorked += calculateHoursWorked(i + 1);
        }
        return totalHoursWorked * getRate(); // Salary = Rate * Total Hours Worked
    }

    // Calculate the number of hours worked on a given day
    private int calculateHoursWorked(int day) {
        if (attendance[day - 1][0][0] != null && attendance[day - 1][1][0] != null) {
            int timeInHour = Integer.parseInt(attendance[day - 1][0][0]);
            int timeOutHour = Integer.parseInt(attendance[day - 1][1][0]);
            return Math.max(0, timeOutHour - timeInHour); // Ensure no negative hours
        }
        return 0;
    }
}
