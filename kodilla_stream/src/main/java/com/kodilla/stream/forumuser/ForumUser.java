package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    //some fields should not be final but for sake of challenge I made them all that way

    //I think enum here works better as it can only have 2 defined values
    public enum sex{
        M,F
    }
    private final int userID;
    private final String userName;
    private final sex userSex;
    private final LocalDate birthdayDate;
    private final int numberOfPosts;

    public ForumUser(final int userID,final String userName,final sex userSex,final LocalDate birthdayDate,final int numberOfPosts) {
        this.userID = userID;
        this.userName = userName;
        this.userSex = userSex;
        this.birthdayDate = birthdayDate;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public sex getUserSex() {
        return userSex;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", birthdayDate=" + birthdayDate +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
