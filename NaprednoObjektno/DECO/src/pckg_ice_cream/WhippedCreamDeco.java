package pckg_ice_cream;

public class WhippedCreamDeco extends IceCreamDecorator{
    protected WhippedCreamDeco(IceCream ic) {
        super(ic);
    }

    @Override
    public void getDescription() {
        decoIceCream.getDescription();
        System.out.println("Decorated with whipped cream!");
    }

    @Override
    public double getPrice() {
        return decoIceCream.getPrice() + this.unitPriceDeco;
    }

    @Override
    public String toString() {
        return "WhippedCreamDeco{" +
                "decoIceCream=" + decoIceCream +
                ", unitPriceDeco=" + unitPriceDeco +
                '}';
    }
}
