public class Player {
    protected String name;
    protected int current_health;
    protected int max_health;
    protected boolean isAlive;
    protected int x_pos;
    protected int y_pos;
    protected int damage;
    protected int defence;

    public Player(String name, int max_health, int damage, int defence){
    this.name = name;
    this.current_health = max_health;
    this.max_health = max_health;
    this.isAlive = true;
    this.x_pos = 0;
    this.y_pos = 0;
    this.damage = damage;
    this.defence = defence;
    }
    public void increaseHealth(int value){
        if (!isAlive) {
        System.out.println(name + " мертв и не может быть исцелен!");
        return;
        }
        int total = value + current_health;
        current_health = (total > max_health) ? max_health: total; 
        if (current_health == max_health){
            System.out.println("Здоровье играка " + name + " максимальна!");
        }
        else{
            System.out.println("Лечение игрока " + name + ". Здоровье: " + current_health);
        }
    }

    public void decreaseHealth(int value){
    if (value <= defence)
    {
        defence -= value;
        System.out.println("Защита игрока " + name + " снижена до: " + defence + "!");
    }
    else
    {
        current_health = current_health + defence - value;
        defence = 0;
        System.out.println("Здоровье игрока " + name + " понижено " + "до: " + current_health);
        
    }
    if (current_health < 0){
        isAlive = false;
        System.out.println("Игрок " + name + " погиб!");
    }
   
    }
    @Override
    public String toString() {
        return String.format("%s [Здоровье: %d/%d, Позиция: (%d,%d), Урон: %d, Защита: %d, Статус: %s]",
                name, current_health, max_health, x_pos, y_pos, damage, defence, 
                isAlive ? "жив" : "мертв");
    }
    }
