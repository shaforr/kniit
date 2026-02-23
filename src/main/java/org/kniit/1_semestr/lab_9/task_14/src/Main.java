import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        String input = scanner.nextLine().trim().toUpperCase();

        try {
            TrafficLight current = TrafficLight.valueOf(input);
            TrafficLight next = current.getNextLight();

            System.out.println("Следующий сигнал: " + next);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: неверный сигнал светофора.");
        }
    }
}
