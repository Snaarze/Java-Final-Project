public class OrderItem {
    private String productName;
    private int quantity;
    private double price;

    public OrderItem(String productName, int quantity, double price) {
        // this if state checks if the there are negative numbers inputted
        if (quantity <= 0 || price < 0) {
            throw new IllegalArgumentException("Quantity and price must be positive.");
        }
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
