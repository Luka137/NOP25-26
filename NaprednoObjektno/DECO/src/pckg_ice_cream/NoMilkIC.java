package pckg_ice_cream;

public abstract class NoMilkIC implements IceCream{

    protected final double unitPrice;

    protected NoMilkIC() {
        this.unitPrice = 3.5;
    }
}
