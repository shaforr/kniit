import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Main{
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {

        List<T> result = new ArrayList<>();

        for (T element : list) {

            if (predicate.test(element)) {
                result.add(element);
            }
        }

        return result;
    }
public static void main(String[] args) {
    

    List<String> words = Arrays.asList("apple", "banana", "cherry");

    List<String> filtered = filter(words, s -> s.startsWith("b"));

    System.out.println(filtered); 
}
}