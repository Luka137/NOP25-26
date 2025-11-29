package pckg_snd_exc;

import java.awt.*;

public class Navigator {
    private RouteStrategy strategy;

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public Route buildRoute(Point p1, Point p2) {
        return strategy.calculate(p1, p2);
    }
}
