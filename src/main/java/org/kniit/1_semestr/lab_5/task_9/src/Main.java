import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        //получает текущее время в миллисекундах
        long currentTimeMillis = System.currentTimeMillis();
        long endTimeMillis = currentTimeMillis + 60000;
        int wordsTotal = 0;
        int correctWordsTotal = 0;
        int charsTotal = 0;
        List<String> words = getWords();
        int wordsInDict = words.size();
        Scanner input = new Scanner(System.in, "ibm866");
        Random random = new Random();
        while(currentTimeMillis < endTimeMillis)
        {
            String currentWord = words.get(random.nextInt(wordsInDict));
            System.out.println("Напишите слово: " + currentWord);
            if (currentTimeMillis >= endTimeMillis){
                System.out.println("Время вышло!");
                break;
                }

            wordsTotal++;
            
            String in = input.nextLine().trim();
            
            
            if (in.compareTo(currentWord) == 0){
                correctWordsTotal++;
                charsTotal += currentWord.length();
                System.out.println("Верно");
            }
            else{
                System.out.println("Неверно!");
            }
            
            currentTimeMillis = System.currentTimeMillis();
            
        }
        double speed = (double) charsTotal / 60;
        System.out.println(String.format(
            "Всего слов: %d\n" +
            "Верных слов: %d\n" +
            "Всего символов верных: %d\n" +
            "Скорость: %.2f симв/сек",
            wordsTotal, correctWordsTotal, charsTotal, speed
        ));
        input.close();
        
    }

    //Возвращает список слов из файла
    public static List<String> getWords() {
        List<String> words = new ArrayList<>();
        try{
        Scanner scanner = new Scanner(new File("dictionary.txt"));
        
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        scanner.close();
        
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " );
            
        }
        return words;
}
}