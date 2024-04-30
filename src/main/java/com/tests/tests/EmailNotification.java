package com.tests.tests;

public class EmailNotification {
    private EmailClient emailClient;

    public EmailNotification(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void notify(String to, String message){
        this.emailClient.send(to,message);
    }
}
