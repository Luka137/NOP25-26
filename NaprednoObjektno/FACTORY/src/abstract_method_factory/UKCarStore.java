package abstract_method_factory;

import pckg_simple_factory.Car;
import pckg_simple_factory.CarType;

public class UKCarStore extends CarStore{

    @Override
    public Car createCar(CarType carType, String model, String manufacturer) {
        Car car = null;

        if(carType.equals(CarType.SUV)){
            car = new UKSUV(manufacturer, model);
        }

        if(carType.equals(CarType.SEDAN)){
            car = new UKSedan(manufacturer, model);
        }

        return car;
    }
}
