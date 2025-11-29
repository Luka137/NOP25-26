package pckg_snd_exc;

public class Route {
    private int time;
    private int distance;
    private int toll;

    public Route(int time, int distance, int toll) {
        this.time = time;
        this.distance = distance;
        this.toll = toll;
    }

    public int getTime(){
        return time;
    }
    public int getDistance(){
        return distance;
    }
    public int getToll(){
        return toll;
    }
}
