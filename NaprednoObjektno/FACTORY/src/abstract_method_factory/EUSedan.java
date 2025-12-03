package abstract_method_factory;

import pckg_simple_factory.Car;

public class EUSedan extends Car {
    protected EUSedan(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public String toString() {
        return "EUSedan{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", date=" + date +
                '}';
    }
}
