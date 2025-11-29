package pckg_no_fasade;

public class Fasada {

    private Amplifier amplifier;
    private Player player;
    private Lights lights;
    private Screen screen;
    private Projector projector;

    public Fasada(Amplifier amp, Player pl, Lights lts, Screen sc, Projector pro){
        this.amplifier = amp;
        this.player = pl;
        this.lights = lts;
        this.screen = sc;
        this.projector = pro;
    }

    public void watchMovie(){
        amplifier.turnOnAmp();
        player.turnOffPlayer();
        screen.pullDownScreen();
        projector.turnONProjector();
        lights.turnOffLights();
    }

    public void stopMovie(){
        lights.turnOnLights();
        player.turnOffPlayer();
        screen.pullUpScreen();
        projector.turnOFFProjector();
        amplifier.turnOffAmp();
    }
}
