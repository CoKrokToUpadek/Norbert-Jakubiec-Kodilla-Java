package com.kodilla.good.patterns.challenges.productOrderServiceChallengeResources;

public class User {

    private final String userName;
    private final String userAddress;
    private final String userEmail;


    public User(String userName, String userAddress, String userEmail) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
    }


    public User(){
        this.userName="tom";
        this.userAddress="potato street 8, warsaw, poland";
        this.userEmail="tom@gmail.com";
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

}
