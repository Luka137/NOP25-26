package pckg_ice_cream;

public class VanillaFlavor extends MilkBasedIC {
    @Override
    public void getDescription() {
        System.out.println("Vanilla flavor ice cream!");
    }

    @Override
    public double getPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "VanillaFlavor{" +
                "unitPrice=" + unitPrice +
                '}';
    }
}
