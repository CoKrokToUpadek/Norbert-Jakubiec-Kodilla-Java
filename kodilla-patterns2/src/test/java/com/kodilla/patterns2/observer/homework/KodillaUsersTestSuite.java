package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

public class KodillaUsersTestSuite {

    @Test
    void notificationsTest(){
        // Given
        KodillaUser user1=new KodillaUser("Jarek");
        KodillaUser user2=new KodillaUser("Elek");
        KodillaUser user3=new KodillaUser("Bartek");
        KodillaUser user4=new KodillaUser("Andrzej");
        KodillaUser user5=new KodillaUser("Celina");
        KodillaUser user6=new KodillaUser("Przemek");

        KodillaMentor mentor1=new KodillaMentor("Ireneusz Kodilla");
        KodillaMentor mentor2=new KodillaMentor("Sylwester Kodilla");

        user1.assignMentor(mentor1);
        user2.assignMentor(mentor1);
        user3.assignMentor(mentor1);

        user4.assignMentor(mentor2);
        user5.assignMentor(mentor2);
        user6.assignMentor(mentor2);
        //when
        user1.sendTask("basic of classes");
        user2.sendTask("debugger task");
        user3.sendTask("compiler task");
        user4.sendTask("simple game task");
        user5.sendTask("structural programming task");
        user5.sendTask("tests task");


    }


}
