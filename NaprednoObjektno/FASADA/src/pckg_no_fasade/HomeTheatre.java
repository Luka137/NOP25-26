package pckg_no_fasade;

public class HomeTheatre {

    private Amplifier amplifier;
    private Player player;
    private Lights lights;
    private Screen screen;
    private Projector projector;


    public HomeTheatre(Amplifier amp, Projector projector, Screen screen, Lights lights, Player player) {
        this.amplifier = amp;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.player = player;
    }


    public void turnLightsOn(){
        lights.turnOnLights();
    }

    public void turnLightsOff(){
        lights.turnOffLights();
    }

    public void turnOnPlayer(){
        player.turnOnPlayer();
    }

    public void turnOffPlayer(){
        player.turnOffPlayer();
    }

    public void turnOnAmp(){
        amplifier.turnOnAmp();
    }

    public void turnOffAmp(){
        amplifier.turnOffAmp();
    }

    public void pullUpScreen(){
        screen.pullUpScreen();
    }

    public void pullDownScreen(){
        screen.pullDownScreen();
    }

    public void projectorON(){
        projector.turnONProjector();
    }

    public void projectorOFF(){
        projector.turnOFFProjector();
    }

}
