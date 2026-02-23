import java.util.Scanner;
import java.util.TreeSet;
public class Main {
    public static void main(String[] args){
        TreeSet<String> studentSet= new TreeSet<String>();
        studentSet.add("Иванов Иван");
        studentSet.add("Андрей Гайдулян");
        studentSet.add("Равиль Курамшин");
        studentSet.add("Сэр Артем");
        Scanner scanner = new Scanner(System.in, "ibm866");
        while (true) {
            System.out.println("\nМеню списка на отчисление:");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Показать всех студентов");
            System.out.println("4. Найти студента");
            System.out.println("5. Поиск по диапазону");
            System.out.println("6. Выйти");
            
            System.out.print("Выберите опцию: ");
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice){
                case 1: {
                    System.out.print("Введите имя студента: ");
                    String name = scanner.nextLine();
                    if (studentSet.contains(name)){
                        System.out.print("Однофамилец???");
                    }
                    else{
                        studentSet.add(name);
                        System.out.print("Студент " + name + "добавлен в список");
                    }
                    break;
                }
                case 2:{
                    String name = scanner.nextLine();
                    studentSet.remove(name);
                    System.out.print("Теперь студента " + name + " нет...");
                    break;
                }
                case 3:
                    if (studentSet.isEmpty()){
                        System.out.print("Список пока пуст");

                    }
                    else
                    {
                        for(String student : studentSet){
                            System.out.println(student);
                        }
                    }
                    break;
                case 4:{
                    System.out.print("Введите имя студента: ");
                    String name = scanner.nextLine();
                    if (studentSet.contains(name)){
                        System.out.print("Студент есть в списке");
                    }
                    else{
                        System.out.print("Студента " + name + " нет в списке");
                    }   
                    break;
                }
                case 5: {
                    String from;
                    String to;
                    while (true){
                        System.out.println("Ведите первого студента: ");
                        from = scanner.nextLine();
                        if (studentSet.contains(from)){
                            break;
                        }
                        else{
                            System.out.println("Такого нет в списке");
                        }
                    }

                    while (true){
                        System.out.println("Ведите второго студента: ");
                        to = scanner.nextLine();
                        if (studentSet.contains(to)){
                            break;
                        }
                        else{
                            System.out.println("Такого нет в списке");
                        }
                    }
                    System.out.println();
                    for (String student : studentSet.subSet(from, to)){
                        System.out.println(student);
                    }
                    System.out.println(to);

                    break;
                }
                case 6:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Нет такой опции!");
            }
    }
}
}
