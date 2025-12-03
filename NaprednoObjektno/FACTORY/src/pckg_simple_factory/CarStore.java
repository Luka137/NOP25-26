package pckg_simple_factory;

public class CarStore {

    private String carStoreName;

    public CarStore(String name){
        this.carStoreName = name;
    }

    public Car orderCar(CarType carType, String model, String manufacturer){
        return SimpleCarCreator.createCar(model,manufacturer,carType);
    }
}
