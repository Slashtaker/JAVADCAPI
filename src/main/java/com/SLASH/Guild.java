package com.SLASH;

import com.google.gson.annotations.SerializedName;

public class Guild {
    @SerializedName("ID")
    private Long ID;

    @SerializedName("Name")
    private String Name;

    @SerializedName("Members_amount")
    private Integer Members_amount;

    @SerializedName("Welcome_Channel_ID")
    private Long Welcome_Channel_ID;

    @SerializedName("Leave_Channel_ID")
    private Long Leave_Channel_ID;

    public Guild(Long ID, String Name, Integer Members_amount, Long Welcome_Channel_ID, Long Leave_Channel_ID) {
        this.ID = ID;
        this.Name = Name;
        this.Members_amount = Members_amount;
        this.Welcome_Channel_ID = Welcome_Channel_ID;
        this.Leave_Channel_ID = Leave_Channel_ID;
    }
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getMembers_amount() {
        return Members_amount;
    }

    public void setMembers_amount(Integer members_amount) {
        Members_amount = members_amount;
    }

    public Long getWelcome_Channel_ID() {
        return Welcome_Channel_ID;
    }

    public void setWelcome_Channel_ID(Long welcome_Channel_ID) {
        Welcome_Channel_ID = welcome_Channel_ID;
    }

    public Long getLeave_Channel_ID() {
        return Leave_Channel_ID;
    }

    public void setLeave_Channel_ID(Long leave_Channel_ID) {
        Leave_Channel_ID = leave_Channel_ID;
    }
}
