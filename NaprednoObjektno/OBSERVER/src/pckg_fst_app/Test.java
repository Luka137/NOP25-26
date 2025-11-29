package pckg_fst_app;

public class Test {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation(23,1024,89);
        MobileWthApp mapp1 = new MobileWthApp();
        MobileWthApp mapp2 = new MobileWthApp();
        ws.add(mapp1);
        ws.add(mapp2);
        ws.setWSData(30,1033,78);

    }
}
