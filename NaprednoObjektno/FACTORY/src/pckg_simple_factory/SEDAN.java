package pckg_simple_factory;

public class SEDAN extends Car{

    protected SEDAN(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public String toString() {
        return "SEDAN{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", date=" + date +
                '}';
    }
}
