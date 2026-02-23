import java.util.Objects;
public class ShopItem{
    private String name;
    private double price;
    private int count;

    public ShopItem(String name, double price, int count)
    {
        setName(name);
        setPrice(price);
        setCount(count);
    }

    public void setName(String name){
        if (name.equals(" ")) throw new IllegalArgumentException("Название не может быть пустым!");   
        this.name = name;
    }
    public void setPrice(double price){
        if (price <= 0) throw new IllegalArgumentException("Цена не может быть меньше нуля!");  
        this.price = price;
    }
    public void setCount(int count){
        if (count < 0) throw new IllegalArgumentException("Количество не может быть отрицательным!");  
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public double getPricePerItem() {
        return (double) price / count;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, price, count);
    }


    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        ShopItem other = (ShopItem) obj;  

        return name.equals(other.name) &&
        Double.compare(price, other.price) == 0 &&
        count == other.count;
    }

    @Override
    public String toString(){
        return String.format("Товар: %s Цена: %.2f Количество: %d", name, price, count);
    }
}
