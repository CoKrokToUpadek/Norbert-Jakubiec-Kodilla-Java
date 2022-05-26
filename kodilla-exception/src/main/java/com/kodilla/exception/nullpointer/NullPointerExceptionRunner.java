package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {

        User user=null;
        Optional<User> optionalUser = Optional.ofNullable(user);

        String username =
                optionalUser.orElse(new User("tom")).getUsername();

        System.out.println(username);



//        User user = null;
//        MessageSender messageSender = new MessageSender();
//
//        try {
//            messageSender.sendMessageTo(user, "Hello!");
//        }catch (MessageNotSentException e){
//            System.out.println("Message is not send," +
//                    "but my program still running very well!");
//        }
//        System.out.println("Processing other logic!");
    }
}
