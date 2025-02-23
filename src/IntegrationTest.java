import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class IntegrationTest {

    private static final String INVENTORY_FILE = "inventory.txt";
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() throws IOException {
        // Delete the inventory file if it exists to start from empty
        Files.deleteIfExists(Path.of(INVENTORY_FILE));
    }

    @AfterEach
    void tearDown() throws IOException {
        // Restore original System.in and System.out
        System.setIn(originalIn);
        System.setOut(originalOut);
        // Clean up the inventory file
        Files.deleteIfExists(Path.of(INVENTORY_FILE));
    }

    @Test
    void testAddAndPersistInventory() throws IOException {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.clearInventory();

        // Simulate valid user input: id, name, quantity, price
        String simulatedInput = "1\nTest Product\n10\n19,99\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        AddProduct addProduct = new AddProduct(inventoryManager);
        addProduct.execute();

        // Verify that the product was added
        Product productBeforeSave = inventoryManager.findProductById(1);
        assertNotNull(productBeforeSave, "Product should be added before saving.");
        assertEquals("Test Product", productBeforeSave.getName(), "Product name should match before saving.");

        // Save the inventory to file
        inventoryManager.saveInventory();

        // Clear the in-memory inventory and reload from file
        inventoryManager.clearInventory();
        assertEquals(0, inventoryManager.getInventory().size(), "Inventory should be empty after clearing.");

        inventoryManager.loadInventory();
        List<Product> loadedInventory = inventoryManager.getInventory();
        assertEquals(1, loadedInventory.size(), "Inventory should have one product after loading.");

        Product loadedProduct = loadedInventory.get(0);
        assertEquals(1, loadedProduct.getId(), "Loaded product ID should match.");
        assertEquals("Test Product", loadedProduct.getName(), "Loaded product name should match.");
        assertEquals(10, loadedProduct.getQuantity(), "Loaded product quantity should match.");
        assertEquals(19.99, loadedProduct.getPrice(), "Loaded product price should match.");
    }

    @Test
    void testAddMultipleAndClearInventory() {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.clearInventory();

        // Simulate input for the first product
        String simulatedInput1 = "2\nFirst Product\n5\n9,99\n";
        System.setIn(new ByteArrayInputStream(simulatedInput1.getBytes()));
        new AddProduct(inventoryManager).execute();
        // Restore System.in for the next product
        System.setIn(originalIn);

        // Simulate input for the second product
        String simulatedInput2 = "3\nSecond Product\n15\n29,99\n";
        System.setIn(new ByteArrayInputStream(simulatedInput2.getBytes()));
        new AddProduct(inventoryManager).execute();
        System.setIn(originalIn);

        // Verify that both products were added
        assertEquals(2, inventoryManager.getInventory().size(), "There should be two products in the inventory.");
        assertNotNull(inventoryManager.findProductById(2), "First product should be present.");
        assertNotNull(inventoryManager.findProductById(3), "Second product should be present.");

        // Clear the inventory and verify it is empty
        inventoryManager.clearInventory();
        assertTrue(inventoryManager.getInventory().isEmpty(), "Inventory should be empty after clearing.");
    }
}
