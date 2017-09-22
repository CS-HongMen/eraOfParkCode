package com.iFox.charRoom;

import com.google.gson.Gson;
import com.iFox.charRoom.vo.Information;
import com.iFox.service.InformationService;
import org.springframework.web.context.ContextLoader;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by exphuhong on 17-9-15.
 * Start
 */

@ServerEndpoint("/chatRoom/{userName}/{imgPath}")
public class ChatRoom {
    private static int onlineCount = 0;

    private Session session;
    private String userName;
    private String imgPath;

    private CopyOnWriteArraySet<ChatRoom> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
    private InformationService informationService = (InformationService) ContextLoader.getCurrentWebApplicationContext().getBean("informationService");
    @OnOpen
    public void onOpen(Session session, @PathParam("userName") String userName, @PathParam("imgPath") String imgPath) {
        this.session = session;
        this.userName = userName;
        this.imgPath = imgPath;
        copyOnWriteArraySet.add(this);
        addOnlineCount();
        System.out.println("新连接打开,当前人数:" + getOnlineCount());
    }

    @OnClose
    public void onClose() {
        copyOnWriteArraySet.remove(this);
        subOnlineCount();
        System.out.println("有连接关闭");

    }

    @OnMessage
    public void onMessage(String message) {
        Gson gson = new Gson();
        LocalDateTime localDateTime = LocalDateTime.now();
        Information information = new Information(userName, imgPath, localDateTime.toString(), message);
        String info = gson.toJson(information);
        informationService.save(information);
        for (ChatRoom chatRoom : copyOnWriteArraySet) {
            try {
                chatRoom.sendMessage(info);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    @OnError
    public void onError(Session session, Throwable throwable) throws IOException {
        session.close();
        throwable.printStackTrace();
    }


    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized int addOnlineCount() {
        return onlineCount++;
    }

    private static synchronized int subOnlineCount() {
        return onlineCount--;
    }
}
