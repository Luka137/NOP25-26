package pckg_Feed_solution;

public class MobileWSAppFeeds implements ObserverWS {

    private WeatherFeed weatherFeedData;

    @Override
    public void setFeedData(WeatherFeed wfd){
        this.weatherFeedData = wfd;
    }
    @Override
    public void updateData() {
        System.out.println("Mobile app: " + this);
        System.out.println("Temperature: " + weatherFeedData.getTemperature());
        System.out.println("Pressure: " + weatherFeedData.getPressure());
        System.out.println("Humidity: " + weatherFeedData.getHumidity());
        System.out.println("-------------------------------------------------------------------");
    }
}
