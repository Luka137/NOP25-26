package pckg_simple_factory;

public class Test {
    static void main(String[] args) {
        CarStore carStore = new CarStore("Best Car selling House");
        Car car = carStore.orderCar(CarType.SUV, "TOYOTA", "RAV4");
        System.out.println(car);
        Car sndCar = carStore.orderCar(CarType.SEDAN, "Renault", "Megane");
        System.out.println(sndCar);
    }
}
