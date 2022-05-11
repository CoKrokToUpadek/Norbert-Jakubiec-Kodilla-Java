package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.List;

public class ForumUser {

    private String name;
    private String realName;
    private List<ForumPost> posts;
    private List<ForumComment> comments;

    public ForumUser(String name, String realName) {

        this.name = name;
        this.realName = realName;
        this.posts = new ArrayList<>();
        this.comments = new ArrayList<>();

    }

    public void addPost(String author, String postBody) {

        ForumPost forumPost=new ForumPost(postBody,author);
        posts.add(forumPost);

    }

    public void addComment(ForumPost post, String author, String commentBody) {

        ForumComment forumComment=new ForumComment(post,commentBody,author);
        comments.add(forumComment);

    }

    public int getPostQuantity() {

        return posts.size();

    }

    public int getCommentQuantity() {

        return comments.size();

    }

    public ForumPost getPost(int postNumber) {

        if (posts.size()>postNumber && postNumber>=0) {
            ForumPost post = posts.get(postNumber);
           return post;
        }
        return null;
    }

    public ForumComment getComment(int commentNumber) {
        ForumComment forumComment=null;
        if (commentNumber>=0 && commentNumber<comments.size()){
            forumComment=comments.get(commentNumber);
            return forumComment;
        }
        return null;
    }

    public boolean removePost(ForumPost thePost) {
        boolean result = false;
        if (posts.contains(thePost)) {
            posts.remove(thePost);
            result = true;
        }
        return result;
    }

    public boolean removeComment(ForumComment theComment) {
        boolean result = false;
        if (comments.contains(theComment)) {
            comments.remove(theComment);
            result = true;
        }
        return result;
    }


    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
