import java.util.Scanner;

// Consumer Class (Data Layer)
class Consumer {
    private int id;
    private String name;
    private int unitsConsumed;

    // Constructor
    public Consumer(int id, String name, int unitsConsumed) {
        this.id = id;
        this.name = name;
        this.unitsConsumed = unitsConsumed;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }
}

// TariffCalculator Class (Logic Layer)
class TariffCalculator {

    public double calculateBill(int units) {
        double bill = 0;

        if (units <= 100) {
            bill = units * 1.5;
        } 
        else if (units <= 300) {
            bill = (100 * 1.5) + ((units - 100) * 2.5);
        } 
        else if (units <= 500) {
            bill = (100 * 1.5) + (200 * 2.5) + ((units - 300) * 4);
        } 
        else {
            bill = (100 * 1.5) + (200 * 2.5) + (200 * 4) + ((units - 500) * 6);
        }

        return bill;
    }
}

// Main Class (Execution Layer)
public class ElectricityBillSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TariffCalculator calculator = new TariffCalculator();

        System.out.println("===== Electricity Bill System =====");

        System.out.print("Enter Consumer ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Consumer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        // Create Consumer Object
        Consumer consumer = new Consumer(id, name, units);

        // Calculate Bill
        double billAmount = calculator.calculateBill(consumer.getUnitsConsumed());

        // Display Output
        System.out.println("\n===== BILL DETAILS =====");
        System.out.println("Consumer ID   : " + consumer.getId());
        System.out.println("Name          : " + consumer.getName());
        System.out.println("Units Used    : " + consumer.getUnitsConsumed());
        System.out.println("Total Bill    : ₹" + billAmount);

        sc.close();
    }
}