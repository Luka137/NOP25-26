package pckg_simple_factory;

public class SUV extends Car{

    protected SUV(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public String toString() {
        return "SUV{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", date=" + date +
                '}';
    }
}
