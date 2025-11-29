package pckg_notification;

public class TestApp {
    static void main(String[] args) {
        BaseNotifier baseNotifier = new BaseNotifier();
        Notifier notifierCompound = new SMSNotifierDecorator(new SlackNotifierDecorator(baseNotifier));
        notifierCompound.sendMessage("Poruka koja ima smisla!");
        baseNotifier.sendMessage("Poruka koja ima smisla!");
    }
}
