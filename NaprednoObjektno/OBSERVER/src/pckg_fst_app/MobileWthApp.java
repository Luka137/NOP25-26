package pckg_fst_app;

public class MobileWthApp implements ObserverI {

    private float temp;
    private float press;
    private float hum;
    private WeatherStation ws;

    public MobileWthApp() {
        System.out.println("Mobile weather app initialized!");
    }

    @Override
    public void setWS(WeatherStation ws){
        this.ws = ws;
    }

    @Override
    public void update() {
        this.temp = ws.getTemp();
        this.press = ws.getPress();
        this.hum = ws.getHumidity();
        System.out.println(this + " update data from WS: " + this.ws);
        System.out.println("Temp: " + this.temp);
        System.out.println("Press: " + this.press);
        System.out.println("Humidity: " + this.hum);
        System.out.println("------------------------------------------------");
        ws.notifyAllObservers();
    }
}
