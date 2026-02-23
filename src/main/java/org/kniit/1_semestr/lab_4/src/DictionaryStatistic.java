import java.util.HashSet;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов 
    private int polindrom; // Количество слов полиндромов
    private int maxWordLength = -1; // маскимальная длина слова в словаре
    private int minWordLength = 999; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индрес - это позиция буквы в alpabet)

    public DictionaryStatistic(String[] words, HashSet<Character> alphabet, int dictionarySize) {
        this.words = words;
        this.alphabet = convertHashSetToCharArray(alphabet);
        this.dictionarySize = dictionarySize;
        this.frequency = new int[alphabet.size()];
    }
    
    private char[] convertHashSetToCharArray(HashSet<Character> set) {
        char[] array = new char[set.size()];
        int index = 0;
        for (Character c : set) {
            array[index++] = c;
        }
        Arrays.sort(array);
        return array;
    }

    private boolean isPolindrom(String word){
        int left = 0;
        int right = word.length() - 1;
        while (left < right)
        {
            if (word.charAt(left) != word.charAt(right)) return false;  
            left++;
            right--;
        } 
        return true;
    }
    public void game() {
    System.out.println("Введите слово: ");
    Scanner scanner = new Scanner(System.in, "ibm866");
    String inputWord = scanner.nextLine().toLowerCase().trim();
    System.out.println("Возможные слова для " + inputWord);
    
    
    for (String word : words) {
        String lowerWord = word.toLowerCase().trim();
        
        if (canFormWord(lowerWord, inputWord)) {
            System.out.println(word);
        }
    }
    //scanner.close();
}
        public boolean canFormWord(String target, String source) {
            
            StringBuilder available = new StringBuilder(source);
            
            for (Character letter : target.toCharArray()) {
                if (Character.isLetter(letter))
                {
                    int index = available.indexOf(String.valueOf(letter));
                    if (index == -1) {
                        return false; 
                    }
                    available.deleteCharAt(index);
                }
            }
            return true;
}
    // получить случайное слово из словаря
    public String getRandomWord() {
       int randomIndex = (int) (Math.random() * dictionarySize);
       return words[randomIndex];
    }

    public void printSymbolsStat() {
        for(int i = 0; i < dictionarySize; i++)
    {
        String word = words[i]; 

        if (isPolindrom(word)) polindrom++;

        int length = word.length();
        if (length > maxWordLength) maxWordLength = length;
        if (length < minWordLength) minWordLength = length;

        for(Character x: word.toCharArray()){
            if (Character.isLetter(x)) frequency[Arrays.binarySearch(alphabet, x)]++;
        }
    }
    
    for(int i = 0; i < frequency.length; i++){
        System.out.println(alphabet[i] + " - " + frequency[i]);
    }
    System.out.println();
    System.out.println("Слов-паллиндромов: " + polindrom);
    System.out.println("Самое длинное слово: " + maxWordLength);
    System.out.println("Самое короткое слово: " + minWordLength);
    }

}