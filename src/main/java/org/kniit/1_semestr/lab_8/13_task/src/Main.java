import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "ibm866");
        List<User> users = new ArrayList<>();

        try {
            users = UserManager.loadUsers();
            System.out.println("Данные успешно загружены из файла.");
        } catch (Exception e) {
            System.out.println("Файл не найден. Начинаем с пустого списка.");
        }

        System.out.println("Добро пожаловать в систему управления пользователями!");

        boolean running = true;

        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить нового пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("3. Сохранить список пользователей в файл");
            System.out.println("4. Загрузить список пользователей из файла");
            System.out.println("5. Выйти");
            System.out.print("Введите номер действия: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();

                    System.out.print("Введите возраст: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.print("Введите email: ");
                    String email = scanner.nextLine();

                    users.add(new User(name, age, email));
                    System.out.println("Пользователь добавлен.");
                    break;

                case "2":
                    System.out.println("Список пользователей:");
                    if (users.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        int index = 1;
                        for (User u : users) {
                            System.out.println(index + ". " + u);
                            index++;
                        }
                    }
                    break;

                case "3":
                    try {
                        UserManager.saveUsers(users);
                        System.out.println("Список успешно сохранён.");
                    } catch (IOException e) {
                        System.out.println("Ошибка сохранения: " + e.getMessage());
                    }
                    break;

                case "4":
                    try {
                        users = UserManager.loadUsers();
                        System.out.println("Список успешно загружен.");
                    } catch (Exception e) {
                        System.out.println("Ошибка загрузки: " + e.getMessage());
                    }
                    break;

                case "5":
                    try {
                        UserManager.saveUsers(users);
                        System.out.println("Данные сохранены. До свидания!");
                    } catch (IOException e) {
                        System.out.println("Ошибка сохранения перед выходом!");
                    }
                    running = false;
                    break;

                default:
                    System.out.println("Неизвестная команда. Повторите ввод.");
            }
        }
    }
}
