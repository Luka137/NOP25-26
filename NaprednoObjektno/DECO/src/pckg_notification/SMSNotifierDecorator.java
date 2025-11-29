package pckg_notification;

public class SMSNotifierDecorator extends NotifierDecorator {

    protected SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage(String msg) {
        notifier.sendMessage(msg);
        System.out.println("SMS msg: " + msg);
    }
}
