import java.util.*;
class Employee {
private final int id;
private String name;
private double salary;
Employee(int id, String name, double salary) {
this.id = id;
this.name = name;
this.salary = salary;
}
public int getId() {
return id;
}
public void setName(String name) {
this.name = name;
}
public void setSalary(double salary) {
this.salary = salary;
}
@Override
public String toString() {
return String.format("ID: %d, Name: %s, Salary: %.2f", id, name, salary);
}
}
public class EmployeeManager {
private static final List<Employee> employees = new ArrayList<>();
private static final Scanner scanner = new Scanner(System.in);
private static void addEmployee() {
System.out.print("Enter ID: ");
int id = scanner.nextInt();
scanner.nextLine();
System.out.print("Enter Name: ");
String name = scanner.nextLine();
System.out.print("Enter Salary: ");
double salary = scanner.nextDouble();
employees.add(new Employee(id, name, salary));
System.out.println("Employee added successfully.");
}
private static void updateEmployee() {
System.out.print("Enter ID to update: ");
int id = scanner.nextInt();
scanner.nextLine();
Employee employee = findEmployeeById(id);
if (employee != null) {
System.out.print("Enter New Name: ");
employee.setName(scanner.nextLine());
System.out.print("Enter New Salary: ");
employee.setSalary(scanner.nextDouble());
System.out.println("Employee updated successfully.");
} else {
System.out.println("Employee not found.");
}
}
private static void removeEmployee() {
System.out.print("Enter ID to remove: ");
int id = scanner.nextInt();
if (employees.removeIf(e -> e.getId() == id)) {
System.out.println("Employee removed successfully.");
} else {
System.out.println("Employee not found.");
}
}
private static void searchEmployee() {
System.out.print("Enter ID to search: ");
int id = scanner.nextInt();
Employee employee = findEmployeeById(id);
if (employee != null) {
System.out.println(employee);
} else {
System.out.println("Employee not found.");
}
}
private static Employee findEmployeeById(int id) {
return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
}
public static void main(String[] args) {
while (true) {
System.out.println(" 1. Add Employee 2. Update Employee 3. Remove Employee 4. Search Employee 5. Exit ");
System.out.print("Choose an option: ");
int choice = scanner.nextInt();
switch (choice) {
case 1 -> addEmployee();
case 2 -> updateEmployee();
case 3 -> removeEmployee();
case 4 -> searchEmployee();
case 5 -> {
System.out.println("Exiting program. Goodbye!");
return;
}
default -> System.out.println("Invalid choice. Please try again.");
}}}}