import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManager {
    static List<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added.");
    }

    static void updateEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        for (Employee e : employees) {
            if (e.id == id) {
                scanner.nextLine();
                System.out.print("New Name: ");
                e.name = scanner.nextLine();
                System.out.print("New Salary: ");
                e.salary = scanner.nextDouble();
                System.out.println("Updated.");
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void removeEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        employees.removeIf(e -> e.id == id);
        System.out.println("Removed.");
    }

    static void searchEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        employees.stream().filter(e -> e.id == id).findFirst()
        .ifPresentOrElse(System.out::println, () -> System.out.println("Not found."));
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add 2. Update 3. Remove 4. Search 5. Exit");
            System.out.print("Choice: ");
            switch (scanner.nextInt()) {
                case 1 -> addEmployee();
                case 2 -> updateEmployee();
                case 3 -> removeEmployee();
                case 4 -> searchEmployee();
                case 5 -> {
                System.out.println("Goodbye!");
                return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}


output:
1. Add 2. Update 3. Remove 4. Search 5. Exit
Choice: 1
Enter ID: 10366
Enter Name: Deepak yadav
Enter Salary: 50000
Employee added.

1. Add 2. Update 3. Remove 4. Search 5. Exit
Choice: 2
Enter ID: 10366
New Name: Deepak yadav
New Salary: 60000
Updated.

1. Add 2. Update 3. Remove 4. Search 5. Exit
Choice: 3
Enter ID: 10366
Removed.

1. Add 2. Update 3. Remove 4. Search 5. Exit
Choice: 4
Enter ID: 10366
Not found.

1. Add 2. Update 3. Remove 4. Search 5. Exit
Choice: 5
Goodbye!
