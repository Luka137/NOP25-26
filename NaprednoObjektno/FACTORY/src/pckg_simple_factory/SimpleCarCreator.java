package pckg_simple_factory;

public class SimpleCarCreator {

    public static Car createCar(String model, String manufacturer, CarType carType){

        Car car = null;
        if(carType.equals(CarType.SUV)){
            car = new SUV(model, manufacturer);
        }

        if(carType.equals(CarType.SEDAN)){
            car = new SEDAN(model, manufacturer);
        }

        return car;
    }
}
