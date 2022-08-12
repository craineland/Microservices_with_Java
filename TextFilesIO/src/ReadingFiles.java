import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingFiles {
    public static void main(String[] args) {
        Path path = Path.of("files/grave-cradle-UTF8.txt");
        boolean exists = Files.exists(path);
        System.out.println("The file exists: " + exists);
    }
}
