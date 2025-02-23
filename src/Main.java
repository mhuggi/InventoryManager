import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.loadInventory();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Update Product Price");
            System.out.println("5. Delete Product");
            System.out.println("6. Search Product");
            System.out.println("7. Generate Inventory Report");
            System.out.println("8. Sort Products by Name");
            System.out.println("9. Sort Products by Price");
            System.out.println("10. Check Low Stock Products");
            System.out.println("11. Filter Products by Price Range");
            System.out.println("12. Clear Inventory");
            System.out.println("13. Save and Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> new AddProduct(inventoryManager).execute();
                case 2 -> new ViewProducts(inventoryManager).execute();
                case 3 -> new UpdateQuantity(inventoryManager).execute();
                case 4 -> new UpdatePrice(inventoryManager).execute();
                case 5 -> new DeleteProduct(inventoryManager).execute();
                case 6 -> new SearchProduct(inventoryManager).execute();
                case 7 -> System.out.println("Inventory Report:\n" + inventoryManager.getInventory());
                case 8 -> new SortProductsByName(inventoryManager).execute();
                case 9 -> new SortProductsByPrice(inventoryManager).execute();
                case 10 -> new CheckLowStock(inventoryManager).execute();
                case 11 -> new FilterByPriceRange(inventoryManager).execute();
                case 12 -> new ClearInventory(inventoryManager).execute();
                case 13 -> {
                    inventoryManager.saveInventory();
                    System.out.println("Inventory saved. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
