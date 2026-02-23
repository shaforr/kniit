

public class Warrior extends Player{
    public Warrior(String name){
        super(name, 100, 10, 25);
    }

    public void attack(Player player)
    {
        player.decreaseHealth(damage);
    }
    @Override
    public String toString(){
        return "Класс: Воин " + super.toString(); 
    }
}
