package pckg_simple_remote;

public class LightCmd implements Command{

    private Light light;

    public LightCmd(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
