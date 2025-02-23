import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMainExit() {

        // Simulate Input with Exit option
        String simulateInput = "13\n";
        InputStream originalIn = System.in;
        ByteArrayInputStream testIn = new ByteArrayInputStream(simulateInput.getBytes());
        System.setIn(testIn);

        // Capture Output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        // Run Main
        Main.main(new String[]{});

        // Check Exit message is printed
        String output = testOut.toString();
        assertTrue(output.contains("Inventory saved. Goodbye!"), "Output should contain correct exit message");

        // Restore original streams
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testMainInvalidChoice() {
        // Simulate invalid option then choose option 13 to exit.
        String simulatedInput = "99\n13\n";
        InputStream originalIn = System.in;
        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testIn);

        // Capture output.
        PrintStream originalOut = System.out;
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        // Run main
        Main.main(new String[]{});

        // Check output contains invalid choice
        String output = testOut.toString();
        assertTrue(output.contains("Invalid choice."),
                "Output should contain 'Invalid choice.' when an invalid option is provided.");

        // Restore original streams
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testMenuOutput() {
        // Simulate Input with Exit option
        String simulateInput = "13\n";
        InputStream originalIn = System.in;
        ByteArrayInputStream testIn = new ByteArrayInputStream(simulateInput.getBytes());
        System.setIn(testIn);

        // Capture Output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        // Run Main
        Main.main(new String[]{});

        // Check output contains correct Menu choices
        String output = testOut.toString();
        assertTrue(output.contains("Inventory Management System"),
                "Output should contain the menu header 'Inventory Management System'.");
        assertTrue(output.contains("1. Add Product"),
                "Output should contain the menu option for 'Add Product'.");

        // Restore original streams.
        System.setIn(originalIn);
        System.setOut(originalOut);

    }

}