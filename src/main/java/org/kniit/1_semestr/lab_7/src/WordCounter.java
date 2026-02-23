
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
public class WordCounter {

    public static void main(String[] args) throws IOException {

        Path startDir = Paths.get("testDir");

        WordFileVisitor visitor = new WordFileVisitor();

        Files.walkFileTree(startDir, visitor);

        System.out.println("Общее количество слов во всех .txt файлах: " + visitor.getTotalWords());
    }
}

