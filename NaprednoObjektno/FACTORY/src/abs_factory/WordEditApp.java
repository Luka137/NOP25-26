package abs_factory;

public class WordEditApp {

    private GUIFactory guiFactory;

    public WordEditApp(GUIFactory guiFactory){
        this.guiFactory = guiFactory;
    }

    public void createGUI(){
        guiFactory.renderGUIApp();
    }

    @Override
    public String toString() {
        return "WordEditApp{" +
                "guiFactory=" + guiFactory +
                '}';
    }
}
