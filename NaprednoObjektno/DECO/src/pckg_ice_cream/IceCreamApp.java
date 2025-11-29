package pckg_ice_cream;

import java.util.ArrayList;
import java.util.List;

public class IceCreamApp {

    private final List<IceCream> iceCreamList;

    public IceCreamApp() {
        this.iceCreamList = new ArrayList<>();
    }

    public void addIceCream(IceCream iceCream){
        iceCreamList.add(iceCream);
        System.out.println(iceCream + " added to a bill list!");
    }

    public void finishOrder(){
        double total = 0.0;
        System.out.println("==================== Order =======================");
        for(IceCream iceCream : iceCreamList){
            System.out.println(iceCream);
            total += iceCream.getPrice();
        }
        System.out.println("Total: " + total + " €");
        iceCreamList.clear();
    }
}
