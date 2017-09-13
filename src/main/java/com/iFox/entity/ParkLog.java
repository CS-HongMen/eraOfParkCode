package com.iFox.entity;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
@Alias("parkLog")
public class ParkLog {

    private final Integer id;
    private final String logInformation;
    private final LocalDateTime logDate;
    private String imgPath;
    private final Integer userId;
    private final Integer surnameCount;

    public ParkLog(Integer id, String logInformation, LocalDateTime logDate, String imgPath, Integer userId, Integer surnameCount) {
        this.id = id;
        this.logInformation = logInformation;
        this.logDate = logDate;
        this.imgPath = imgPath;
        this.userId = userId;
        this.surnameCount = surnameCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkLog parkLog = (ParkLog) o;

        if (id != null ? !id.equals(parkLog.id) : parkLog.id != null) return false;
        if (logInformation != null ? !logInformation.equals(parkLog.logInformation) : parkLog.logInformation != null)
            return false;
        if (logDate != null ? !logDate.equals(parkLog.logDate) : parkLog.logDate != null) return false;
        if (imgPath != null ? !imgPath.equals(parkLog.imgPath) : parkLog.imgPath != null) return false;
        if (userId != null ? !userId.equals(parkLog.userId) : parkLog.userId != null) return false;
        return surnameCount != null ? surnameCount.equals(parkLog.surnameCount) : parkLog.surnameCount == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (logInformation != null ? logInformation.hashCode() : 0);
        result = 31 * result + (logDate != null ? logDate.hashCode() : 0);
        result = 31 * result + (imgPath != null ? imgPath.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (surnameCount != null ? surnameCount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParkLog{" +
                "id=" + id +
                ", logInformation='" + logInformation + '\'' +
                ", logDate=" + logDate +
                ", imgPath='" + imgPath + '\'' +
                ", userId=" + userId +
                ", surnameCount=" + surnameCount +
                '}';
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public String getLogInformation() {
        return logInformation;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getSurnameCount() {
        return surnameCount;
    }
}
