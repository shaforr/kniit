package org.example;

import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {

        UserService service = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] cmd = input.split("\\s+");

            try {
                switch (cmd[0]) {
                    case "add" -> service.registerUser(cmd[1], cmd[2]);

                    case "list" -> service.listAllUsers()
                            .forEach(System.out::println);

                    case "delete" -> service.deleteUser(Integer.parseInt(cmd[1]));

                    case "update" -> service.updateUser(
                            Integer.parseInt(cmd[1]), cmd[2], cmd[3]);

                    case "exit" -> System.exit(0);

                    default -> System.out.println("Неизвестная команда");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}