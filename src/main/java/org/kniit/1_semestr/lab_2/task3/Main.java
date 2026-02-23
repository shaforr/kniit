


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = "", second = "", operator = "";
        String exit = "exit";
        boolean flag = true;
        System.out.println("Начало");
        while (true){
            
            while (flag){
            System.out.println("Введите первое число: ");
            first = in.nextLine();
            if (first.equals(exit)){
                System.out.println("Закрытие...");
                flag = false;
                break;
            }
            if (isDouble(first))break;
            System.out.println("Ошибка: введено не число!");
            }

            while(flag){
            System.out.println("Введите оператор (+-*/): ");
            operator = in.nextLine();
            if (operator.equals(exit)){
                System.out.println("Закрытие...");
                flag = false;
                break;
            }
            if ("+-/*".indexOf(operator) != -1) break;
            System.out.println("Ошибка: оператор может быть только из набора (+-*/)");
            }

            while(flag){
            System.out.println("Введите второе число: ");
            second = in.nextLine();
            if (second.equals(exit)){
                System.out.println("Закрытие...");
                flag = false;
                break;
            }
            if (isDouble(second))break;
            System.out.println("Ошибка: введено не число!");
            }

            

            if (!flag)break;

            Calculator calc = new Calculator();
            calc.setFirst(Double.parseDouble(first));
            calc.setSecond(Double.parseDouble(second));
            calc.setOperator(operator);
            
            System.out.println("Результат: " + calc.Calculate());
            
        }
        in.close();
        
    }
    

    public static boolean isDouble(String num) {
        if (num == null || num.isEmpty()) {
            return false;
        }
        try{
            Double.parseDouble(num);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}