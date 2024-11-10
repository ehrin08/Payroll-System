class Attendance {
    private String[] employeeIds;
    private String[][] attendanceRecords;
    private int[] attendanceCounts;
    private int capacity;
    private int size;

    public Attendance(int capacity) {
        this.capacity = capacity;
        employeeIds = new String[capacity];
        attendanceRecords = new String[capacity][30]; // max 30 days of attendance
        attendanceCounts = new int[capacity];
        size = 0;
    }

    public void markAttendance(String employeeId, String date) {
        for (int i = 0; i < size; i++) {
            if (employeeIds[i].equals(employeeId)) {
                attendanceRecords[i][attendanceCounts[i]] = date;
                attendanceCounts[i]++;
                return;
            }
        }
        // If employee ID not found, add new record
        if (size < capacity) {
            employeeIds[size] = employeeId;
            attendanceRecords[size][0] = date;
            attendanceCounts[size] = 1;
            size++;
        }
    }

    public String[] getAttendance(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employeeIds[i].equals(employeeId)) {
                String[] records = new String[attendanceCounts[i]];
                for (int j = 0; j < attendanceCounts[i]; j++) {
                    records[j] = attendanceRecords[i][j];
                }
                return records;
            }
        }
        return new String[0]; // Return empty array if no records found
    }
}