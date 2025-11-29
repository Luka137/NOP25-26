package pckg_Event_solution;


public class TestAppWthStation {
    static void main(String[] args) {
        WSUpdated wsUpdated = new WSUpdated(14,1200,77);
        MobileWthAppNew mobileWthAppNew1 = new MobileWthAppNew();
        MobileWthAppNew mobileWthAppNew2 = new MobileWthAppNew();
        wsUpdated.registerObserver(mobileWthAppNew1);
        wsUpdated.registerObserver(mobileWthAppNew2);
        wsUpdated.notifyRegisteredObservers();
    }
}
