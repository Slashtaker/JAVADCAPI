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

    @SerializedName("Welcome_Message")
    private String[] Welcome_Message;

    @SerializedName("Leave_Message")
    private String[] Leave_Message;

    public Guild(Long ID, String Name, Integer Members_amount, Long Welcome_Channel_ID, Long Leave_Channel_ID, String[] Welcome_Message, String[] Leave_Message) {
        this.ID = ID;
        this.Name = Name;
        this.Members_amount = Members_amount;
        this.Welcome_Channel_ID = Welcome_Channel_ID;
        this.Leave_Channel_ID = Leave_Channel_ID;
        this.Welcome_Message = Welcome_Message;
        this.Leave_Message = Leave_Message;
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

    public String[] getWelcome_Message() {
        return Welcome_Message;
    }

    public void addWelcome_Message(String message) {
        String[] temp = Welcome_Message;
        Welcome_Message = new String[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            Welcome_Message[i] = temp[i];
        }
        Welcome_Message[Welcome_Message.length - 1] = message;
    }

    public void RemoveWelcome_Message(int index) {
        String[] temp = Welcome_Message;
        Welcome_Message = new String[temp.length - 1];
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            if (i != index) {
                Welcome_Message[j] = temp[i];
                j++;
            }
        }
    }

    public void setWelcome_Message(String[] welcome_Message) {
        Welcome_Message = welcome_Message;
    }

    public String[] getLeave_Message() {
        return Leave_Message;
    }

    public void addLeave_Message(String message) {
        String[] temp = Leave_Message;
        Leave_Message = new String[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            Leave_Message[i] = temp[i];
        }
        Leave_Message[Leave_Message.length - 1] = message;
    }

    public void RemoveLeave_Message(int index) {
        String[] temp = Leave_Message;
        Leave_Message = new String[temp.length - 1];
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            if (i != index) {
                Leave_Message[j] = temp[i];
                j++;
            }
        }
    }
    public void setLeave_Message(String[] leave_Message) {
        Leave_Message = leave_Message;
    }
}
