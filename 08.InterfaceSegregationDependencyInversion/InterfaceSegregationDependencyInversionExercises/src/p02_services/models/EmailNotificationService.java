package p02_services.models;

import p02_services.interfaces.NotificationService;

public class EmailNotificationService implements NotificationService {

    private boolean isActive;

    public EmailNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    public void sendNotification() {
    }

    public boolean isActive() {
        return this.isActive;
    }
}
