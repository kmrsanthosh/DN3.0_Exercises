public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public EmployeeManagementSystem() {
        employees = new Employee[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(Employee employee) {
        if (size == employees.length) {
            Employee[] newEmployees = new Employee[employees.length * 2];
            System.arraycopy(employees, 0, newEmployees, 0, employees.length);
            employees = newEmployees;
        }
        employees[size++] = employee;
    }

    public Employee search(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean delete(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // Add
        ems.add(new Employee(1, "John Doe", "Developer", 75000));
        ems.add(new Employee(2, "Jane Smith", "Manager", 90000));
        ems.add(new Employee(3, "Bob Johnson", "Designer", 65000));

        // Traverse
        System.out.println("All employees:");
        ems.traverse();

        // Search
        Employee foundEmployee = ems.search(2);
        System.out.println("\nFound employee: " + foundEmployee);

        // Delete
        boolean deleted = ems.delete(1);
        System.out.println("\nEmployee deleted: " + deleted);

        // Traverse again
        System.out.println("\nEmployees after deletion:");
        ems.traverse();
    }
}