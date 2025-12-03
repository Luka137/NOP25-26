package abstract_method_factory;

import pckg_simple_factory.Car;
import pckg_simple_factory.CarType;

public abstract class CarStore {

    protected Car orderCar(CarType carType, String model, String manufacturer){
        Car car = createCar(carType, model, manufacturer);
        return car;
    }

    protected abstract Car createCar(CarType carType, String model, String manufacturer);

}
