package abs_factory;

public class MACGUIFactory implements GUIFactory{

    @Override
    public void renderGUIApp() {
        MACButton macButton = new MACButton();
        macButton.renderButton();
        MACList macList = new MACList();
        macList.renderList();
        MACCheckBox macCheckBox = new MACCheckBox();
        macCheckBox.renderCheckBox();
        MACComboBox macComboBox = new MACComboBox();
        macComboBox.renderCombo();
    }

    @Override
    public String toString() {
        return "MACGUIFactory{... rendering all for GUI}";
    }
}
