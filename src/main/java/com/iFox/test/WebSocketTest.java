package com.iFox.test;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by exphuhong on 17-9-15.
 * Start
 */
public class WebSocketTest {
    private static WebSocketClient webSocketClient;

    public static void main(String[] args) throws URISyntaxException {
        webSocketClient = new WebSocketClient(new URI("ws://localhost:8080/chatRoom/CS-ZLF/1-1")) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("open");
                webSocketClient.send("张玲飞是猪");
            }

            @Override
            public void onMessage(String s) {
                System.out.println(s);
            }

            @Override
            public void onClose(int i, String s, boolean b) {

            }

            @Override
            public void onError(Exception e) {

            }
        };
        webSocketClient.connect();

    }

}
