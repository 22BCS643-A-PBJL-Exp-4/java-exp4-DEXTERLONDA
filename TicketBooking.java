import java.util.*;
class TicketBookingSystem {
private int vipSeats, regularSeats;
public TicketBookingSystem(int vipSeats, int regularSeats) {
this.vipSeats = vipSeats;
this.regularSeats = regularSeats;
}
public synchronized void bookTicket(String name, String type) {
if (type.equalsIgnoreCase("VIP") && vipSeats > 0) {
vipSeats--;
System.out.println(name + " booked a VIP ticket. Remaining: " + vipSeats);
} else if (type.equalsIgnoreCase("Regular") && regularSeats > 0) {
regularSeats--;
System.out.println(name + " booked a Regular ticket. Remaining: " +
regularSeats);
} else {
System.out.println(name + " failed to book a " + type + " ticket.");
}
}
}
public class TicketBooking {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter VIP seats: ");
int vipSeats = scanner.nextInt();
System.out.print("Enter Regular seats: ");
int regularSeats = scanner.nextInt();
scanner.nextLine();
TicketBookingSystem system = new TicketBookingSystem(vipSeats, regularSeats);
System.out.print("Enter number of customers: ");
int n = scanner.nextInt();
scanner.nextLine();
for (int i = 0; i < n; i++) {
System.out.print("Enter customer name: ");
String name = scanner.nextLine();
System.out.print("Enter ticket type (VIP/Regular): ");
String type = scanner.nextLine();
system.bookTicket(name, type);
}
scanner.close();}}