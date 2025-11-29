package pckg_Event_solution;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WSUpdated implements ObservableWS<WeatherSensorReading>{

    private final List<GenObserver<WeatherSensorReading>> observers;
    private WeatherSensorReading wsr;

    public WSUpdated(float temp, float press, float humidity) {
        this.observers = new CopyOnWriteArrayList<>();
        this.wsr = new WeatherSensorReading(temp, press, humidity, Instant.now());
    }

    public void setDataFromSensors(float t, float p, float h){
        this.wsr = new WeatherSensorReading(t, p, h, Instant.now());
    }

    @Override
    public void registerObserver(GenObserver<WeatherSensorReading> genObs) {
        if(this.observers.contains(genObs)){
            System.out.println("Already in the list!");
        } else{
            this.observers.add(genObs);
            System.out.println("Added new observer to WS!");
        }
    }

    @Override
    public void removeObserverFromList(GenObserver<WeatherSensorReading> genObs) {

    }

    @Override
    public void notifyRegisteredObservers() {
        for(GenObserver<WeatherSensorReading> genObserver : this.observers){
            genObserver.update(this.wsr);
        }
    }
    }
