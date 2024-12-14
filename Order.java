import java.util.List;

class Order {
    private static int counter = 0;
    private int orderId;
    private List<Products> items;

    public Order(List<Products> items) {
        this.orderId = ++counter;
        this.items = items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order ID: " + orderId + "\n");
        for (Products item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
