import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
public class Game {
    private int wordLength;
    private String guessedWord;
    private ArrayList<Character> arrayWords;
    private HashSet<Character> setWords;
    private HashSet<Character> setPlayer;
    private int attempt = 6;

    public Game(String guessedWord){
        this.guessedWord = guessedWord;
        this.wordLength = guessedWord.length();
        this.arrayWords = StringToEmptyList(guessedWord);
        this.setWords = StringToHashSet(guessedWord);
        this.setPlayer = new HashSet<Character>();
    }

    public void startGame(){
        
        System.out.println(guessedWord);
        Scanner input = new Scanner(System.in, "ibm866");

        while (true){
            if (attempt == 0) break;
            if (setPlayer.equals(setWords)) break;
            print(arrayWords);
            System.out.println("Введите букву: ");
            Character userChar = input.nextLine().trim().charAt(0);

            if (setWords.contains(userChar)){
                setPlayer.add(userChar);
                ArrayFilling(arrayWords, guessedWord, setPlayer);
            }
            else{
                attempt--;
                System.out.println("Неверно! Осталось попыток: " + attempt);
            }
        }
    input.close();
    }
    public HashSet<Character> StringToHashSet(String str){
        HashSet<Character> set = new HashSet<Character>();
        for(Character c : str.toCharArray()){
            set.add(c);
        }
        return set;
    } 
    public void ArrayFilling(ArrayList<Character> list, String word, HashSet set){
         
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (set.contains(c)) list.set(i, Character.valueOf(c));
        }
    }

    public void print(List<Character> array){
            for(int i = 0; i < array.size(); i++){
                System.out.print(array.get(i) + " ");
            }
        }
    public void print(HashSet<Character> array){
            for (Character element : array) {
                System.out.println(array);
            }
        }

    public ArrayList<Character> StringToEmptyList(String str){
            ArrayList<Character> list = new ArrayList<Character>();
            for(int i = 0; i < str.length(); i++){
                list.add('_');
            }
            return list;
        }
}
