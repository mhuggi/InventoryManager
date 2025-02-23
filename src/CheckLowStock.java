public class CheckLowStock {
    private final InventoryManager inventoryManager;

    public CheckLowStock(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        int threshold = 10;
        boolean found = false;
        System.out.println("Low Stock Products (Quantity < " + threshold + "):");
        for (Product product : inventoryManager.getInventory()) {
            if (product.getQuantity() < threshold) {
                System.out.println(product.display());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products with low stock.");
        }
    }
}
