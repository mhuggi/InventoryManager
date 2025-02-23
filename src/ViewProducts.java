public class ViewProducts {
    private final InventoryManager inventoryManager;

    public ViewProducts(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        if (inventoryManager.getInventory().isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        System.out.println("Inventory:");
        for (Product product : inventoryManager.getInventory()) {
            System.out.println(product.display());
        }
    }
}
