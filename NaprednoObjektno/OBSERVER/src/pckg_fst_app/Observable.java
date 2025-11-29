package pckg_fst_app;

public interface Observable {

    void add(ObserverI ob);
    void remove(ObserverI ob);
    void notifyAllObservers();
}
