package com.tests.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class EmailNotificationTest {

    @Mock
    private EmailClient emailClientMock;

    @Test
    public void testNotify(){
        EmailNotification notification = new EmailNotification(emailClientMock);
        notification.notify("newangeled@gmail.com", "hello world!");

        verify(emailClientMock).send("newangeled@gmail.com", "hello world!");
    }

    @Test
    public void testNotifyNoAddress(){
        EmailNotification notification = new EmailNotification(emailClientMock);
        notification.notify(null, "Message");
        verify(emailClientMock, times(0)).send(anyString(), anyString());
    }

    @Test
    public void testNotificationNullMessage(){
        EmailNotification notification = new EmailNotification(emailClientMock);
        notification.notify("newangeled@gmail.com", null);

        verify(emailClientMock, times(0)).send(anyString(),anyString());
    }

    @Test
    public void testNotificationEmptyTo(){
        EmailNotification notification = new EmailNotification(emailClientMock);
        notification.notify("", "message");

        verify(emailClientMock,never()).send(eq(""),eq(""));
    }

    @Test
    public void testNotificationEmptyMessage(){
        EmailNotification notification = new EmailNotification(emailClientMock);
        notification.notify("newangeled@gmail.com", "");

        verify(emailClientMock,never()).send(eq(""),eq(""));
    }


}
