package pckg_Event_solution;

public class MobileWthAppNew implements GenObserver<WeatherSensorReading> {

    @Override
    public void update(WeatherSensorReading event) {
        System.out.println("Mobile App: " + this);
        System.out.println(event.temp());
        System.out.println(event.press());
        System.out.println(event.humidity());
        System.out.println(event.atTime());
        System.out.println(event);
        System.out.println("----------------------------------------------------");
    }
}
