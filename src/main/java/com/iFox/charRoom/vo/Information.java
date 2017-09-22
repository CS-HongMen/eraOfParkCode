package com.iFox.charRoom.vo;


/**
 * Created by exphuhong on 17-9-15.
 * Start
 */

public class Information {
    private String userName;
    private String imgPath;
    private String sendTime;
    private String content;



    public Information() {
        
    }

    @Override
    public String toString() {
        return "Information{" +
                "userName='" + userName + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", sendTime=" + sendTime +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Information that = (Information) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (imgPath != null ? !imgPath.equals(that.imgPath) : that.imgPath != null) return false;
        if (sendTime != null ? !sendTime.equals(that.sendTime) : that.sendTime != null) return false;
        return content != null ? content.equals(that.content) : that.content == null;

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (imgPath != null ? imgPath.hashCode() : 0);
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public Information(String userName, String imgPath, String sendTime, String content) {
        this.userName = userName;
        this.imgPath = imgPath;
        this.sendTime = sendTime;
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getimgPath() {
        return imgPath;
    }

    public void setimgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
