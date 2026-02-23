import java.lang.Math;
import java.util.Comparator;
public class SortByPricePerItem implements Comparator<ShopItem>{
    @Override
    public int compare(ShopItem Item1, ShopItem Item2){
        return Double.compare(Item1.getPricePerItem(), Item2.getPricePerItem());
    }
}
