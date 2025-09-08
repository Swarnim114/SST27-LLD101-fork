package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String whatsAppId;

    public WhatsAppDecorator(Notifier notifier, String whatsAppId) {
        super(notifier);
        this.whatsAppId = whatsAppId;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        System.out.println("[WhatsApp -> " + whatsAppId + "]: " + text);
    }
}
