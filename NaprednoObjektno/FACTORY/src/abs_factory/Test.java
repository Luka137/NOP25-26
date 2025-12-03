package abs_factory;

public class Test {
    static void main(String[] args) {
        WordEditApp wordEditAppM = new WordEditApp(new MACGUIFactory());
        wordEditAppM.createGUI();
        System.out.println(wordEditAppM);
        WordEditApp wordEditAppW = new WordEditApp(new WINGUIFactory());
        wordEditAppW.createGUI();
        System.out.println(wordEditAppW);
    }
}
