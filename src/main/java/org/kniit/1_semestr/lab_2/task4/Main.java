public class Main {
    public static void main(String[] args) {
     
        Container container = new Container(1000);  // Создаем контейнер с объемом 1000

        Shape sphere = new Sphere(5);   // Создаем сферу с радиусом 5
        Shape cube = new Cube(3);       // Создаем куб со стороной 3

        container.add(sphere);  // Проверяем, можно ли добавить сферу
        container.add(cube);    // Проверяем, можно ли добавить куб
    }
}