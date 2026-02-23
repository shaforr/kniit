import java.util.ArrayList;
import java.util.List;
public class Box<T extends Number> {

    private List<T> numbers = new ArrayList<>();

    public void add(T number) {
        numbers.add(number);
    }

    public double sum() {
        double result = 0.0;

        for (T number : numbers) {
            result += number.doubleValue();
        }

        return result;
    }
}