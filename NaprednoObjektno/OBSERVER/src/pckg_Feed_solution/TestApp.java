package pckg_Feed_solution;

public class TestApp {

    static void main(String[] args) {
        WSWithFeed wsWithFeed = new WSWithFeed(15,1200,67);
        MobileWSAppFeeds mobileWSAppFeeds1 =  new MobileWSAppFeeds();
        MobileWSAppFeeds mobileWSAppFeeds2 = new MobileWSAppFeeds();
        wsWithFeed.registerObserver(mobileWSAppFeeds1);
        wsWithFeed.registerObserver(mobileWSAppFeeds2);
        wsWithFeed.notifyAllRegObservers();
        wsWithFeed.sensorsDataChanged(9,1003,89);
    }
}
