import java.util.*;

//This class provides the entire application access to a common scanner.
//This is an example of the Simpleton Pattern.
public class ScannerSingleton {
    private static Scanner scanner;

    public static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
