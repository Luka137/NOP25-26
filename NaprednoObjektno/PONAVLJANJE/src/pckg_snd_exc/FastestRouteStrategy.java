package pckg_snd_exc;


import java.awt.*;

public class FastestRouteStrategy implements RouteStrategy {

    @Override
    public Route calculate(Point p1, Point p2) {
        int distance = (int) p1.distance(p2);
        int time = distance * 5;
        int tool = 10;
        return new Route(distance, time, tool);
    }
}
