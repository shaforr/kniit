public class Main {
    public static void main(String[] args)
    {
        WarriorTank warrior = new WarriorTank("Some Ork");
        Mage mage = new Mage("Some Mage");
        Priest priest = new Priest("Some Healer");
        warrior.attack(mage);
        priest.heal(mage);
        mage.castSpell(warrior);
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);
    }
}
