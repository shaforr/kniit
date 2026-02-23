

class Main {
public static <T> void printType(T obj) {

        if (obj == null) {
            System.out.println("null");
            return;
        }

        System.out.println(obj.getClass().getName());
    }


public static void main(String[] args) {
        printType(123);      // java.lang.Integer
        printType("Hello"); // java.lang.String
    }
}
