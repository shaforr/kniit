

public class Priest extends Player{
    public Priest(String name){
        super(name, 50, 5, 15);
    }
    public void heal(Player player){
        player.increaseHealth(10);
    }
    public void attack(Player player){
        System.out.println("Жрец не может аттаковать!");
    }
    @Override
    public String toString(){
        return "Класс: Жрец " + super.toString(); 
    }
}
