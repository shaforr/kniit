package lab1.task1;

public class Main {

   public static void main(String[] args) {
      for(int var0 = 1; var0 <= 100; ++var0) {
         String var1 = (var0 % 10 != 0) ? Integer.toString(var0) + ", " : Integer.toString(var0) + "\n";
         System.out.print(var1);
      }

   }
}