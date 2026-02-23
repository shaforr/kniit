import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
class WordFileVisitor extends SimpleFileVisitor<Path> {

    private int totalWords = 0;

    public int getTotalWords() {
        return totalWords;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (file.toString().endsWith(".txt")) {
            String content = Files.readString(file);
            String[] words = content.split("\\s+");
            totalWords += words.length;
            System.out.println("Файл: " + file + " — слов: " + words.length);
        }

        return FileVisitResult.CONTINUE;
    }
}