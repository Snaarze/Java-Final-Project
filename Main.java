import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager manager = new OrderManager();

        while (true) {
            // ask the user which operation to take
            System.out.println("\n1. Add Order\n2. Cancel Order\n3. View Customer Orders\n4. Filter by Status\n5. Most Ordered Product\n6. Save Logs\n7. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    // this case operation add an order that is attached to the customer
                    case 1:
                        System.out.print("Customer Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Customer ID: ");
                        String id = scanner.nextLine();
                        Customer customer = new Customer(name, id);
                        Order order = new Order(customer);

                       
                         System.out.print("Product Name: ");
                        String product = scanner.nextLine();
                        System.out.print("Quantity: ");
                        int qty = scanner.nextInt();
                        System.out.print("Price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); //

                        order.addItem(new OrderItem(product, qty, price));


                        manager.addOrder(order);
                        break;

                    case 2:
                    // this case will ask the user to Enter the Order ID to cancel/refunt the order
                        System.out.print("Enter Order ID to cancel: ");
                        String orderId = scanner.nextLine();
                        manager.cancelOrder(orderId);
                        break;

                    case 3:
                    // this case will display the Customer Orders by identifying the Customer name and find if it is existing inside the array
                        System.out.print("Customer Name: ");
                        String custName = scanner.nextLine();
                        manager.viewCustomerOrders(custName);
                        break;

                    case 4:
                    // this case will display all the completed/cancelled orders filtered by the user
                        System.out.print("Status (Completed/Cancelled): ");
                        String status = scanner.nextLine();
                        manager.filterByStatus(status);
                        break;

                    case 5:
                    // this case will show the highest Ordered Products
                        manager.showMostOrderedProduct();
                        break;

                    case 6:
                    // this case will saves all the transaction inside this program to txt
                        manager.saveLogsToFile();
                        break;

                    case 7:
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
