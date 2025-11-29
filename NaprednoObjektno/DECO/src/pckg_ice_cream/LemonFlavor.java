package pckg_ice_cream;

public class LemonFlavor extends NoMilkIC {
    @Override
    public void getDescription() {
        System.out.println("Lemon flavor ice cream!");
    }

    @Override
    public double getPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "LemonFlavor{" +
                "unitPrice=" + unitPrice +
                '}';
    }
}
