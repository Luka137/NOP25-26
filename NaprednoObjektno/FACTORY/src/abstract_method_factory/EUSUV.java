package abstract_method_factory;

import pckg_simple_factory.Car;

public class EUSUV extends Car {
    protected EUSUV(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public String toString() {
        return "EUSUV{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", date=" + date +
                '}';
    }
}
