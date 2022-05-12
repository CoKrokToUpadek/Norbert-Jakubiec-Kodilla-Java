package com.kodilla.testing.forum.statistics;

public class ForumData {
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public ForumData() {
        this.usersCount = 0;
        this.postsCount = 0;
        this.commentsCount = 0;
        this.averagePostsPerUser = 0;
        this.averageCommentsPerUser = 0;
        this.averageCommentsPerPost = 0;
    }

    public void  calculateAdvStatistics(Statistics statistics){

        usersCount=statistics.usersNames().size();
        commentsCount= statistics.commentsCount();
        postsCount=statistics.postsCount();


        if (usersCount<0 || postsCount<0 || commentsCount<0){

            averageCommentsPerUser=-1;
            averageCommentsPerPost=-1;
            averagePostsPerUser=-1;
            return;
        }

        if(usersCount==0 && (postsCount>0 || commentsCount>0)){
            averageCommentsPerUser=-1;
            averageCommentsPerPost=-1;
            averagePostsPerUser=-1;
            return;
        }

        if(commentsCount>0 && postsCount==0){
            averageCommentsPerUser=-1;
            averageCommentsPerPost=-1;
            averagePostsPerUser=-1;
            return;
        }


        if (usersCount==0 || postsCount==0){
            averagePostsPerUser=0;
        }else {
            averagePostsPerUser=(double)postsCount/(double)usersCount;
        }

        if(usersCount==0 || postsCount==0){
            averageCommentsPerPost=0;
        }else {
            averageCommentsPerPost=(double)commentsCount/(double)postsCount;
        }


        if(usersCount==0 || commentsCount==0){
            averageCommentsPerUser=0;
        }else{
            averageCommentsPerUser=(double) commentsCount/(double)usersCount;
        }

    }

    public void showStatistics(){
        System.out.println("current users count: "+usersCount);
        System.out.println("current comments count: "+commentsCount);
        System.out.println("current posts count: "+postsCount);
        System.out.println("average posts per user: "+averagePostsPerUser);
        System.out.println("average comments per post:: "+averageCommentsPerPost);
        System.out.println("average comments per user: "+averageCommentsPerUser);
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
