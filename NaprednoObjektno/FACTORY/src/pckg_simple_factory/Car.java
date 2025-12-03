package pckg_simple_factory;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Car {

    protected String model;
    protected String manufacturer;
    protected static final LocalDate START = LocalDate.parse("2000-02-01");
    protected static final LocalDate STOP = LocalDate.parse("2025-10-01");
    protected LocalDate date;

    protected Car(String manufacturer, String model){
        this.model = model;
        this.manufacturer = manufacturer;
        this.date = getDate();
    }

    private LocalDate getDate(){
        long start = START.toEpochDay();
        long stop = STOP.toEpochDay();
        long randomDateLong = ThreadLocalRandom.current().nextLong(start, stop+1);

        return LocalDate.ofEpochDay(randomDateLong);
    }

}
