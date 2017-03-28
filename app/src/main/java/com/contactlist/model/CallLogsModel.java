package com.contactlist.model;

/**
 * Created by Ketan on 3/19/17.
 */

public class CallLogsModel {

    private String name;

    private String pic;

    private String mobile;

    private String email;

    private String lastContactTime;

    private String totalTalkTime;

    public CallLogsModel(){}

    public CallLogsModel(String name, String pic, String mobile, String email, String lastContactTime, String totalTalkTime) {
        this.name = name;
        this.pic = pic;
        this.mobile = mobile;
        this.email = email;
        this.lastContactTime = lastContactTime;
        this.totalTalkTime = totalTalkTime;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastContactTime() {
        return lastContactTime;
    }

    public void setLastContactTime(String lastContactTime) {
        this.lastContactTime = lastContactTime;
    }

    public String getTotalTalkTime() {
        return totalTalkTime;
    }

    public void setTotalTalkTime(String totalTalkTime) {
        this.totalTalkTime = totalTalkTime;
    }
}
