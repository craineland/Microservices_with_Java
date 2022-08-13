import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritingFiles {
    public static void main(String[] args) {
        Path path = Path.of("files/debug.log");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("The loss of efficacy happens naturally with aging.");
            writer.flush();
        }
        catch (IOException IOex) {
            System.err.println("Error: " + IOex.getMessage());
        }
    }
}
