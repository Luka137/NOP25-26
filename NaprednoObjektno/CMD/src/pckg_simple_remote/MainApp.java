package pckg_simple_remote;

public class MainApp {
    static void main(String[] args) {
        RemoteController simpleRC = new RemoteController();
        GarageDoor garageDoor = new GarageDoor();
        Light light = new Light();
        simpleRC.setCommand(new GarageDoorCmd(garageDoor));
        simpleRC.remoteControllerButtonPress();
        simpleRC.remoteControllerButtonPress();
        simpleRC.setCommand(new LightCmd(light));
        simpleRC.remoteControllerButtonPress();
        simpleRC.remoteControllerButtonPress();
    }
}
