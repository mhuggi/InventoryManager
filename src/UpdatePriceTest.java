import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

class UpdatePriceRegressionTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream testOut;
    private InventoryManager inventoryManager;

    @BeforeEach
    void setUp() {
        // Set up a fresh InventoryManager and output capture for each test.
        inventoryManager = new InventoryManager();
        inventoryManager.clearInventory();
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void tearDown() {
        // Restore original System streams.
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testUpdatePriceSuccess() {
        // Arrange: Add a product with known details.
        Product product = new Product(1, "Test Product", 10, 20.0);
        inventoryManager.addProduct(product);

        // Simulate valid input: product ID "1" and new price "30.5".
        String simulatedInput = "1\n30,5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Act: Execute the UpdatePrice command.
        UpdatePrice updatePrice = new UpdatePrice(inventoryManager);
        updatePrice.execute();

        // Assert: Verify that the product's price was updated.
        Product updated = inventoryManager.findProductById(1);
        assertNotNull(updated, "Product should exist.");
        assertEquals(30.5, updated.getPrice(), "Product price should be updated to 30.5.");

        // Also, ensure that other fields remain unchanged.
        assertEquals("Test Product", updated.getName(), "Product name should remain unchanged.");
        assertEquals(10, updated.getQuantity(), "Product quantity should remain unchanged.");

        // And the output should indicate success.
        String output = testOut.toString();
        assertTrue(output.contains("Price updated successfully."),
                "Output should contain the success message.");
    }

    @Test
    void testUpdatePriceProductNotFound() {
        // Arrange: Leave the inventory empty.
        // Simulate input for a non-existent product ID.
        String simulatedInput = "999\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Act: Execute the UpdatePrice command.
        UpdatePrice updatePrice = new UpdatePrice(inventoryManager);
        updatePrice.execute();

        // Assert: Verify that the output indicates the product was not found.
        String output = testOut.toString();
        assertTrue(output.contains("Product not found."),
                "Output should indicate that the product was not found.");
    }
}
