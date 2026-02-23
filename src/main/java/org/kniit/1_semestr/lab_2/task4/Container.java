public class Container {
    private double total, free;

    public Container(double total)
    {
        this.total = total;
        this.free = total;
    }

    public void add(Shape shape)
    {
        double shapeVolume = shape.getVolume();
        if (free >= shapeVolume){
            free -= shapeVolume; 
            System.out.println("Фигура добавлена!"  );
            System.out.println("Свободно места: " + String.format("%.2f", free) + " из " + String.format("%.2f", total));
        }
        else{
            System.out.println("Фигура не добавлена!");
            System.out.println("Места не хватило: " + String.format("%.2f", shapeVolume - free) + " из " + String.format("%.2f", total));
        }
    }
}
