package com.kodilla.stream.forumuser;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> forumUsers=new ArrayList<>();

    public Forum() {

        forumUsers.add(new ForumUser(1,"Owca",ForumUser.sex.M, LocalDate.of(2000,1,10),1));
        forumUsers.add(new ForumUser(2,"Lama",ForumUser.sex.M, LocalDate.of(1990,1,10),5));
        forumUsers.add(new ForumUser(3,"Dzik",ForumUser.sex.F, LocalDate.of(1921,1,10),0));
        forumUsers.add(new ForumUser(4,"Jenot",ForumUser.sex.M, LocalDate.of(1927,2,11),0));
        forumUsers.add(new ForumUser(5,"Jeleń",ForumUser.sex.M, LocalDate.of(1927,2,11),1));
        forumUsers.add(new ForumUser(6,"Stonka",ForumUser.sex.F, LocalDate.of(1927,2,11),31));
        forumUsers.add(new ForumUser(7,"Kremówkowe_Jeti",ForumUser.sex.M, LocalDate.of(2010,2,11),31));
    }

    public List<ForumUser> getForumUsers() {
        return new ArrayList<>(forumUsers);
    }
}
