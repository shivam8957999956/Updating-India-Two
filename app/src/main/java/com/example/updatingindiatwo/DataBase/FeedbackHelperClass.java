package com.example.updatingindiatwo.DataBase;

public class FeedbackHelperClass {
    public FeedbackHelperClass() {
    }

    String phoneNumber, name, feedback;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getFeedback() {
        return feedback;
    }



    public FeedbackHelperClass(String phoneNumber, String name, String feedback) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.feedback = feedback;
    }

}
