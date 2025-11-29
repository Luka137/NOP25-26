package pckg_ice_cream;

public abstract class IceCreamDecorator implements IceCream {

    protected IceCream decoIceCream;
    protected final double unitPriceDeco;

    protected IceCreamDecorator(IceCream ic){
        this.decoIceCream = ic;
        this.unitPriceDeco = 0.5;
    }
}
