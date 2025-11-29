package pckg_Feed_solution;


public interface WthStationObservable {

    void registerObserver(ObserverWS observerWS);
    void unregisterObserver(ObserverWS observerWS);
    void notifyAllRegObservers();
}
