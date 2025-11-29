package pckg_notification;

public class BaseNotifier implements Notifier {

    @Override
    public void sendMessage(String msg) {
        System.out.println("EMAIL: sending msg: " + msg);
    }
}
