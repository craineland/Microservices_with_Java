import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVFileAnalysis {
    public static void main(String[] args) {
        Path path = Path.of("files/data.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int i = 1;
            String line = reader.readLine();
            while (line != null) {
                if (!line.startsWith("\"")) {
                    String[] elements = line.split(",");
                    String index = elements[0];
                    String name = elements[1];
                    double cost = Double.parseDouble(elements[2]);
                    double tax = Double.parseDouble(elements[3]);
                    double total = Double.parseDouble(elements[4]);

                    Item item = new Item(index, name, cost, tax, total);
                    System.out.println("Item: " + item);
                }

                line = reader.readLine();
                ++i;
            }
        }
        catch (IOException IOex) {
            IOex.printStackTrace();
        }
    }
}
