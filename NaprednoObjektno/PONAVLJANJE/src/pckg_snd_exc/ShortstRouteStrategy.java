package pckg_snd_exc;

import java.awt.*;

public class ShortstRouteStrategy implements RouteStrategy {

    @Override
    public Route calculate(Point p1, Point p2) {
        int distance = (int) p1.distance(p2);
        int time = distance * 10;
        int tool = 5;
        return new Route(distance, time, tool);
    }
}
