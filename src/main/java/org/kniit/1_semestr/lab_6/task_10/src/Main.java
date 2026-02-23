

public class Main {
    public static void main(String[] args){
        RandomWords rnd = new RandomWords();
        String guessedWord = rnd.getRandomWord();
        Game game = new Game(guessedWord);
        
        game.startGame();
        
    }
    
    
}
