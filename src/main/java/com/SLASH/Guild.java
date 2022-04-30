package com.SLASH;

import com.google.gson.annotations.SerializedName;

public class Guild {
    @SerializedName("ID")
    private Integer ID;

    @SerializedName("Name")
    private String Name;

    @SerializedName("Members_amount")
    private Integer Members_amount;

    @SerializedName("Welcome_Channel_ID")
    private Long Welcome_Channel_ID;

    @SerializedName("Leave_Channel_ID")
    private Long Leave_Channel_ID;

    @SerializedName("Prefix")
    private String Prefix;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
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

    public Long getWelcome_ID() {
        return Welcome_Channel_ID;
    }

    public void setWelcome_ID(Long welcome_ID) {
        Welcome_Channel_ID = welcome_ID;
    }

    public Long getLeave_ID() {
        return Leave_Channel_ID;
    }

    public void setLeave_ID(Long leave_ID) {
        Leave_Channel_ID = leave_ID;
    }

    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String prefix) {
        Prefix = prefix;
    }
}
