package electricitybillingsystem;

import java.util.Scanner;

public class ElectricityBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     // Customer class
        class Customer {
            private int customerId;
            private String name;
            private String address;

            public Customer(int customerId, String name, String address) {
                this.customerId = customerId;
                this.name = name;
                this.address = address;
            }

            public int getCustomerId() {
                return customerId;
            }

            public String getName() {
                return name;
            }

            public String getAddress() {
                return address;
            }
        }

        // ElectricityBill class
        class ElectricityBill {
            private int billId;
            private int customerId;
            private double unitsConsumed;
            private double totalAmount;

            public ElectricityBill(int billId, int customerId, double unitsConsumed) {
                this.billId = billId;
 
                this.customerId = customerId;
                this.unitsConsumed = unitsConsumed;
                this.totalAmount = calculateTotalAmount(unitsConsumed);
            }

            private double calculateTotalAmount(double unitsConsumed) {
                if (unitsConsumed <= 100) {
                    return unitsConsumed * 0.10; // $0.10 per unit for 0-100 units
                } else if (unitsConsumed <= 200) {
                    return 10 + ((unitsConsumed - 100) * 0.15); // $0.15 per unit for 101-200 units
                } else {
                    return 25 + ((unitsConsumed - 200) * 0.20); // $0.20 per unit for 201+ units
                }
            }

            public int getBillId() {
                return billId;
            }

            public int getCustomerId() {
                return customerId;
            }

            public double getUnitsConsumed() {
                return unitsConsumed;
            }

            public double getTotalAmount() {
                return totalAmount;
            }
        }

        // Get customer details from user input
        System.out.println("Enter customer ID:");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        System.out.println("Enter customer address:");
        String address = scanner.nextLine();

        // Get electricity usage details from user input
        System.out.println("Enter units consumed:");
        double unitsConsumed = scanner.nextDouble();

        // Create customer and electricity bill objects
        Customer customer = new Customer(customerId, name, address);
        ElectricityBill bill = new ElectricityBill(1, customerId, unitsConsumed);

        // Display customer information and bill details
        System.out.println("\nCustomer Information:");
        System.out.println("ID: " + customer.getCustomerId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());

        System.out.println("\nElectricity Bill Details:");
        System.out.println("Units Consumed: " + bill.getUnitsConsumed());
        System.out.println("Total Amount: $" + bill.getTotalAmount());

        scanner.close();
    }

}