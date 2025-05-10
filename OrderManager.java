import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void cancelOrder(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                order.cancelOrder();
                return;
            }
        }
        System.out.println("Order ID not found.");
    }

    public void viewCustomerOrders(String customerName) {
        for (Order order : orders) {
            if (order.getCustomer().getName().equalsIgnoreCase(customerName)) {
                System.out.println(order);
            }
        }
    }

    public void filterByStatus(String status) {
        for (Order order : orders) {
            if (order.getOrderStatus().equalsIgnoreCase(status)) {
                System.out.println(order);
            }
        }
    }

    public void showMostOrderedProduct() {
        Map<String, Integer> productCounts = new HashMap<>();

        for (Order order : orders) {
            for (OrderItem item : order.getItems()) {
                productCounts.put(item.getProductName(),
                    productCounts.getOrDefault(item.getProductName(), 0) + item.getQuantity());
            }
        }

        String mostOrdered = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : productCounts.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostOrdered = entry.getKey();
            }
        }

        System.out.println("Most ordered product: " + (mostOrdered != null ? mostOrdered : "None"));
    }

    public void saveLogsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order_logs.txt"))) {
            for (Order order : orders) {
                writer.write(order.toString());
                writer.newLine();
            }
            System.out.println("Order logs saved to order_logs.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
