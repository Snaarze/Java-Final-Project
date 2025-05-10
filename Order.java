import java.util.ArrayList;
import java.util.List;

public class Order implements Trackable, Refundable {
    private static int idCounter = 1000;
    private String orderId;
    private Customer customer;
    private List<OrderItem> items;
    private String status;

    public Order(Customer customer) {
        this.orderId = "ORD" + (++idCounter);
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = "Completed";
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getOrderStatus() {
        return status;
    }

    public void cancelOrder() {
        this.status = "Cancelled";
        processRefund();
    }

    @Override
    public void processRefund() {
        System.out.println("Refund processed for Order ID: " + orderId);
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
    }

    @Override
    public String toString() {
        return String.format("OrderID: %s, Customer: %s, Status: %s, Total: %.2f",
                orderId, customer.getName(), status, getTotalAmount());
    }
}
