import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        String[] names = {"книга", "ручка", "линейка", "пинал", "бибки", "чашка","самовар", "слюпа", "черемша", "зеленка", "конфети"};
        int countSameItems = 0;
        ShopItem[] myArray = new ShopItem[100]; 
        SortByPricePerItem comparator = new SortByPricePerItem();
        for (int i = 0; i < 100; i++){
            
            Random random = new Random();
            int index = random.nextInt(11);
            double price = random.nextInt(1, 10) * 10 + 0.99;
            int count = random.nextInt(1, 100);
            myArray[i] = new ShopItem(names[index], price, count);
        }
        Arrays.sort(myArray, comparator);
        for (int i = 0; i < 100; i++){
            System.out.println(myArray[i] + "   " + myArray[i].getPricePerItem());
            if (i != 99 && comparator.compare(myArray[i], myArray[i + 1]) == 0){
                countSameItems++;
            }
        }
    System.out.println(countSameItems);
    }

}
