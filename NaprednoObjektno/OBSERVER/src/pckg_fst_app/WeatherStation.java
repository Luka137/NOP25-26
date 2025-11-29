package pckg_fst_app;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WeatherStation implements Observable {

    private float temp;
    private float press;
    private float humidity;
    private final List<ObserverI> observers;

    public WeatherStation(float temp, float press, float humidity){
        this.temp = temp;
        this.press = press;
        this.humidity = humidity;
        System.out.println("Weather station created!");
        this.observers = new CopyOnWriteArrayList<>();
        notifyAllObservers();
    }

    @Override
    public void add(ObserverI ob) {
        if(observers.contains(ob)){
            System.out.println("Observer is already subscribed!");
        }else{
            observers.add(ob);
            System.out.println("Added new observer!");
            ob.setWS(this);
        }
    }

    @Override
    public void remove(ObserverI ob) {

    }

    @Override
    public void notifyAllObservers() {
        for(ObserverI obs : observers) {
            obs.update();
        }
    }

    public float getTemp() {
        return temp;
    }

    public float getPress() {
        return press;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setWSData(float t, float p, float h){
        this.temp = t;
        this.press = p;
        this.humidity = h;
        notifyAllObservers();
    }

}
