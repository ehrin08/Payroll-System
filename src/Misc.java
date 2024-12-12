import java.io.IOException;

public class Misc {
    // Clears the screen (if implemented)
    public void clearScreen() {
        System.out.println("\n\n\n\n\n\n");
    }

    // Pause screen for the user to press Enter to continue
    public void pauseScreen() {
        System.out.println("\nPress Enter to continue...");
        try {
            System.in.read();  // Wait for the user to press Enter
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
