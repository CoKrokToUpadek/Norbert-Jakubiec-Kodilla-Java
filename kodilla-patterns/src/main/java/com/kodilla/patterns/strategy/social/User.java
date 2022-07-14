package com.kodilla.patterns.strategy.social;

public class User {
    protected String username;
    protected SocialPublisher media;
    public User(String username) {
        this.username = username;
    }

    public String sharePost(){
        System.out.println(media.share());
        return media.share();
    }

    public void setMedia(SocialPublisher media) {
        this.media = media;
    }

    public String getUsername() {
        return username;
    }
}
