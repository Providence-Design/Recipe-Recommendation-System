import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ReadStringMethod {
    public static void main(String[] args) throws IOException {
        Path fileName  = Path.of("DataFolder/recipes.csv");
        String content = "Dish";
        Files.writeString(fileName, content);
        String actual = Files.readString(fileName);
        System.out.println(actual);

    }
}
