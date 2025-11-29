package pckg_simple_remote;

public class GarageDoorCmd implements Command {
    private GarageDoor garageDoor;

    public GarageDoorCmd(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.open();
        garageDoor.lightOn();
    }

    @Override
    public void undo() {
        garageDoor.close();
        garageDoor.lightOff();
    }
}
