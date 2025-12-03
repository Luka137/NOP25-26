package abstract_method_factory;

import pckg_simple_factory.Car;
import pckg_simple_factory.CarType;

public class TestApp {
    static void main(String[] args) {
        CarStore euCarStore = new EUCarStore();
        CarStore ukCarStore = new UKCarStore();
        Car ukSedan = ukCarStore.orderCar(CarType.SEDAN, "M3", "BMW");
        Car euSUV = euCarStore.orderCar(CarType.SUV, "Duster", "Dacia");
        System.out.println(ukSedan);
        System.out.println(euSUV);
    }
}
