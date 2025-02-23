import java.util.Scanner;

public class FilterByPriceRange {
    private final InventoryManager inventoryManager;

    public FilterByPriceRange(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Minimum Price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter Maximum Price: ");
        double maxPrice = scanner.nextDouble();

        boolean found = false;
        System.out.println("Products within Price Range (" + minPrice + " - " + maxPrice + "):");
        for (Product product : inventoryManager.getInventory()) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                System.out.println(product.display());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products within the specified price range.");
        }
    }
}
