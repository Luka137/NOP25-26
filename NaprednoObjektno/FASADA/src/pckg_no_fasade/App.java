package pckg_no_fasade;

public class App {

    static void main(String[] args) {
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();
        Screen screen = new Screen();
        Lights lights = new Lights();
        Player player = new Player();
        HomeTheatre homeTheatre = new HomeTheatre(amplifier, projector, screen, lights, player);
        homeTheatre.projectorON();
        homeTheatre.turnOnPlayer();
        homeTheatre.turnOnAmp();
        homeTheatre.pullUpScreen();
        homeTheatre.turnLightsOff();
        //some time after
        homeTheatre.turnLightsOn();
        homeTheatre.projectorOFF();
        homeTheatre.turnOffPlayer();
        homeTheatre.turnOffAmp();
        homeTheatre.pullDownScreen();
    }
}
