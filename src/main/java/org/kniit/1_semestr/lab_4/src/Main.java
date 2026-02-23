import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner wordsCountScanner = new Scanner(new File("dictionary.txt"));
            HashSet<Character> alphabet = new HashSet<Character>();
            ArrayList<String> wordList = new ArrayList<>();

            while (wordsCountScanner.hasNext()) {
                String word = wordsCountScanner.nextLine();
                if (!word.isEmpty()) {
                    wordList.add(word);
                for(Character c : word.toLowerCase().toCharArray()){
                    if (Character.isLetter(c)) alphabet.add(c);
                }
            }
            }
            wordsCountScanner.close();

            String[] words = wordList.toArray(new String[0]);
            
            DictionaryStatistic test = new DictionaryStatistic(words, alphabet, words.length);
            test.printSymbolsStat();
            System.out.println();
            System.out.println(test.getRandomWord());
            test.game();
            
        } catch (FileNotFoundException e) {
            System.out.println("Файл dictionary.txt не найден!");
        }
    }
}