package pckg_notification;

public class SlackNotifierDecorator extends NotifierDecorator {

    protected SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage(String msg) {
        notifier.sendMessage(msg);
        System.out.println("SLACK msg: " + msg);
    }
}
