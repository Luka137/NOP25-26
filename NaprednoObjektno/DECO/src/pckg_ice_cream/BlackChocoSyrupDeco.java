package pckg_ice_cream;

public class BlackChocoSyrupDeco extends IceCreamDecorator{
    protected BlackChocoSyrupDeco(IceCream ic) {
        super(ic);
    }

    @Override
    public void getDescription() {
        decoIceCream.getDescription();
        System.out.println("Decorated with black choco syrup!");
    }

    @Override
    public double getPrice() {
        return decoIceCream.getPrice() + this.unitPriceDeco;
    }

    @Override
    public String toString() {
        return "BlackChocoSyrupDeco{" +
                "decoIceCream=" + decoIceCream +
                ", unitPriceDeco=" + unitPriceDeco +
                '}';
    }
}
