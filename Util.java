//This class provides a way to read in files!
//A utility class providing helper functions and common methods that can be used across various classes, like accepting strings from files.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {
    private static Random random = new Random();

    public static String getRandomLineFromFile(String filePath) {
        String currentDirectory = System.getProperty("user.dir");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = new ArrayList<>();
            String line;

            br.readLine(); // Read and discard the header line

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            if (!lines.isEmpty()) {
                return lines.get(random.nextInt(lines.size()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}