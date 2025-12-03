package abstract_method_factory;

import pckg_simple_factory.Car;

public class UKSedan extends Car {
    protected UKSedan(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public String toString() {
        return "UKSedan{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", date=" + date +
                '}';
    }
}
