import java.util.Scanner;

public class ECommercePlatform {
    private static Admin admin = new Admin("Md. Abdur Razzak", "razzak72abdur@gmail.com");
    private static Customer customer = new Customer("John Doe", "john@example.com");

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println(ConsoleColors.CYAN_BG + ConsoleColors.BOLD + "**************> Welcome to MarrShop! <***********" + ConsoleColors.RESET);
            System.out.println();
            System.out.println(ConsoleColors.BLUE + "Login as:" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "1. Admin" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2. Customer" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "3. Exit" + ConsoleColors.RESET);
            System.out.println();

            System.out.println();
            System.out.print(ConsoleColors.PURPLE + "Enter your choice: " + ConsoleColors.RESET);
            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1 -> adminMenu(admin);
                case 2 -> customerMenu(customer);
                case 3 -> {
                    System.out.println();
                    System.out.println(ConsoleColors.BOLD + ConsoleColors.GREEN + "<<<<<<<<Thank you for using MarrShop!>>>>>>>>" + ConsoleColors.RESET);
                    System.out.println();
                    return;
                }
                default -> System.out.println(ConsoleColors.RED + "Invalid choice. Try again." + ConsoleColors.RESET);
            }
        }
    }

    private static void adminMenu(Admin admin) {
        while (true) {
            System.out.println(ConsoleColors.GREEN_BG + ConsoleColors.BOLD + "Admin Panel" + ConsoleColors.RESET);
            admin.displayMenu();

            System.out.println();
            System.out.print(ConsoleColors.YELLOW + "Enter your choice: " + ConsoleColors.RESET);
            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println(ConsoleColors.BLUE + "Enter product details (name, price, stock):" + ConsoleColors.RESET);
                    String name = new Scanner(System.in).nextLine();
                    double price = new Scanner(System.in).nextDouble();
                    int stock = new Scanner(System.in).nextInt();
                    System.out.println();
                    admin.addProduct(new Products(name, price, stock));
                }
                case 2 -> admin.viewProducts();
                case 3 -> {
                    System.out.println(ConsoleColors.BOLD + ConsoleColors.RED + "Exiting admin panel..." + ConsoleColors.RESET);
                    return;
                }
                default -> System.out.println(ConsoleColors.RED + "Invalid choice. Try again." + ConsoleColors.RESET);
            }
        }
    }

    private static void customerMenu(Customer customer) {
        while (true) {
            System.out.println(ConsoleColors.BLUE_BG + ConsoleColors.BOLD + "Customer Panel" + ConsoleColors.RESET);
            customer.displayMenu();

            System.out.println();
            System.out.print(ConsoleColors.YELLOW + "Enter your choice: " + ConsoleColors.RESET);
            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1 -> admin.viewProducts();
                case 2 -> {
                    System.out.println(ConsoleColors.BLUE + "Enter product name to add to cart:" + ConsoleColors.RESET);
                    String productName = new Scanner(System.in).nextLine();
                    Products product = admin.getProducts().stream()
                            .filter(p -> p.getName().equalsIgnoreCase(productName))
                            .findFirst()
                            .orElse(null);
                    if (product != null) {
                        customer.getCart().addItem(product);
                        System.out.println(ConsoleColors.GREEN + "Product added to cart!" + ConsoleColors.RESET);
                    } else {
                        System.out.println(ConsoleColors.RED + "Product not found." + ConsoleColors.RESET);
                    }
                }
                case 3 -> System.out.println(customer.getCart());
                case 4 -> customer.placeOrder();
                case 5 -> customer.viewOrders();
                case 6 -> {
                    System.out.println(ConsoleColors.BOLD + ConsoleColors.RED + "Exiting customer panel..." + ConsoleColors.RESET);
                    return;
                }
                default -> System.out.println(ConsoleColors.RED + "Invalid choice. Try again." + ConsoleColors.RESET);
            }
        }
    }
}
