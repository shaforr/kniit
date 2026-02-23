

public class Mage extends Player {
    public Mage(String name){
        super(name, 80, 5, 5);
    }

    public void castSpell(Player player){
        for (int i = 0; i < 4; i++){
            player.decreaseHealth(damage);
            System.out.println("Прошло 10 секунд");
        }
    }
    @Override
    public String toString(){
        return "Класс: Маг " + super.toString(); 
    }
}
