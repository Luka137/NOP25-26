package abstract_method_factory;

import pckg_simple_factory.Car;

public class UKSUV extends Car {
    protected UKSUV(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public String toString() {
        return "UKSUV{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", date=" + date +
                '}';
    }
}
