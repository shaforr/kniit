import java.util.Random;
public class RandomWords {
    
    private Random random = new Random();
    private String[] words = {
        "безмятежный",
        "хрустальный",
        "мерцание",
        "таинственный",
        "сияние",
        "прозрачный",
        "отражение",
        "эволюция",
        "синтез",
        "анализировать",
        "гипотеза",
        "парадокс",
        "интуиция",
        "феномен",
        "структура"
    };

    public String getRandomWord(){
        return words[random.nextInt(words.length)];
    }
}