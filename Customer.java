import java.util.ArrayList;
import java.util.List;

class Customer extends User {
    private Cart cart;
    private List<Order> orders;

    public Customer(String name, String email) {
        super(name, email);
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public Cart getCart() {
        return cart;
    }

    public void placeOrder() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Cart is empty! Add items to place an order.");
            return;
        }
        orders.add(new Order(new ArrayList<>(cart.getItems())));
        cart.clearCart();
        System.out.println("Order placed successfully!");
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Override
    public void displayMenu() {
        System.out.println();
        System.out.println("Welcome Customer: " + name);
        System.out.println("1. View Products");
        System.out.println("2. Add Product to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Place Order");
        System.out.println("5. View Orders");
        System.out.println("6. Exit");
        System.out.println();
    }
}
