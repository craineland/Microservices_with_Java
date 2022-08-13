import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingFiles {
    public static void main(String[] args) {
        Path path = Path.of("files/grave-cradle-UTF8.txt");
        boolean exists = Files.exists(path);
        System.out.println("The file exists: " + exists);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int i = 1;
            String line = reader.readLine();
            while (line != null) {
                System.out.println(i + ":\t" + line);
                line = reader.readLine();
                ++i;
            }
        }
        catch (IOException IOex) {
            IOex.printStackTrace();
        }


    }
}
