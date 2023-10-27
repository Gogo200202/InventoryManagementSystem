import com.aplication.AplicationLogic;
import com.aplication.DataBase.DB;
import com.aplication.Items.ElectronicsItem;
import com.aplication.Items.GroceryItem;
import com.aplication.abstracts.InventoryItem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

      /*  DB db=new DB();
        ElectronicsItem e=new ElectronicsItem("Tv","15Inch",1000);
        GroceryItem g=new GroceryItem("Apple","Big and red",2);
        List<InventoryItem>items=new ArrayList<>();
        items.add(e);
        items.add(g);
        db.write(items);*/

        AplicationLogic ap=new AplicationLogic();
        ap.showAllItemsInCategory();

    }
}