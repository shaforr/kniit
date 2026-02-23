import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> deck = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(rank.getNameRus() + " " + suit.getNameRus());
            }
        }

        System.out.println("Стандартная 52-карточная колода:");
        for (String card : deck) {
            System.out.println(card);
        }
    }
}
