

public class WarriorTank extends Warrior{
    public WarriorTank(String name){
        super(name);
        this.max_health = 115;
        this.current_health = this.max_health;
        this.damage = 15;
        this.defence = 50;
    }
    @Override
    public String toString(){
        return "Класс: Танк " + super.toString(); 
    }
}
