package com.iFox.entity;

import java.time.LocalDate;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public class ParkComment {

    private Integer id;
    private String comInformation;
    private LocalDate comDate;
    private Integer logId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkComment that = (ParkComment) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (comInformation != null ? !comInformation.equals(that.comInformation) : that.comInformation != null)
            return false;
        if (comDate != null ? !comDate.equals(that.comDate) : that.comDate != null) return false;
        return logId != null ? logId.equals(that.logId) : that.logId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (comInformation != null ? comInformation.hashCode() : 0);
        result = 31 * result + (comDate != null ? comDate.hashCode() : 0);
        result = 31 * result + (logId != null ? logId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParkComment{" +
                "id=" + id +
                ", comInformation='" + comInformation + '\'' +
                ", comDate=" + comDate +
                ", logId=" + logId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComInformation() {
        return comInformation;
    }

    public void setComInformation(String comInformation) {
        this.comInformation = comInformation;
    }

    public LocalDate getComDate() {
        return comDate;
    }

    public void setComDate(LocalDate comDate) {
        this.comDate = comDate;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public ParkComment() {
    }

    public ParkComment(Integer id, String comInformation, LocalDate comDate, Integer logId) {
        this.id = id;
        this.comInformation = comInformation;
        this.comDate = comDate;
        this.logId = logId;
    }
}
