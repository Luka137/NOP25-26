package abs_factory;

public class WINGUIFactory implements GUIFactory{

    @Override
    public void renderGUIApp() {
        WINButton winButton = new WINButton();
        winButton.renderButton();
        WINList winList = new WINList();
        winList.renderList();
        WINCheckBox winCheckBox = new WINCheckBox();
        winCheckBox.renderCheckBox();
        WINComboBox winComboBox = new WINComboBox();
        winComboBox.renderCombo();
    }

    @Override
    public String toString() {
        return "WINGUIFactory{... rendering all for GUI}";
    }
}
