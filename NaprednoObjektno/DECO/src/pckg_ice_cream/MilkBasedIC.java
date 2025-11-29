package pckg_ice_cream;

public abstract class MilkBasedIC implements IceCream {

    protected final double unitPrice;

    protected MilkBasedIC() {
        this.unitPrice = 2.5;
    }
}
