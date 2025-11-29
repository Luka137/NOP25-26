package pckg_Feed_solution;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WSWithFeed implements WthStationObservable, WeatherFeed{

    private float temp;
    private float press;
    private float humidity;
    private final List<ObserverWS> observers;

    public WSWithFeed(float t, float p, float h) {
        this.temp = t;
        this.press = p;
        this.humidity = h;
        this.observers = new CopyOnWriteArrayList<>();
    }



    @Override
    public float getTemperature() {
        return this.temp;
    }

    @Override
    public float getPressure() {
        return this.press;
    }

    @Override
    public float getHumidity() {
        return this.humidity;
    }

    @Override
    public void registerObserver(ObserverWS observerWS) {
        if(observers.contains(observerWS)){
            System.out.println("This one is in list!");
        }else{
            observers.add(observerWS);
            System.out.println("Added new observer to WS!");
        }
    }

    @Override
    public void unregisterObserver(ObserverWS observerWS) {

    }

    public void sensorsDataChanged(float t, float p, float h) {
        this.temp = t;
        this.press = p;
        this.humidity = h;
        notifyAllRegObservers();
    }

    @Override
    public void notifyAllRegObservers() {
        for(ObserverWS observerWS : observers){
            WeatherFeed wf = new WSWithFeed(this.temp,this.press,this.humidity);
            observerWS.setFeedData(wf);
            observerWS.updateData();
        }
    }
}
