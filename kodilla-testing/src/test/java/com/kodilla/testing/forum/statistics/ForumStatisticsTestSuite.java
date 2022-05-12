package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;


public class ForumStatisticsTestSuite {

    ForumData forumData=new ForumData();
    List<String> usersNames=new ArrayList<>();

    double averagePostsPerUser = 0;
    double averageCommentsPerUser = 0;
    double averageCommentsPerPost = 0;

    @Mock
    private Statistics forumStatisticsMock;

    public void populateArray(int numberOfPPl){
        usersNames.clear();
        for (int i=0;i<numberOfPPl;i++){
            usersNames.add(""+i);
        }
    }

    private void WhenThenSetup(int postCount, int commentCount, int userCount){
        populateArray(userCount);
        when(forumStatisticsMock.postsCount()).thenReturn(postCount);
        when(forumStatisticsMock.commentsCount()).thenReturn(commentCount);
        when(forumStatisticsMock.usersNames()).thenReturn(usersNames);
        forumData.calculateAdvStatistics(forumStatisticsMock);
    }

    private void dataAssign(){
        averagePostsPerUser = forumData.getAveragePostsPerUser();
        averageCommentsPerUser = forumData.getAverageCommentsPerUser();
        averageCommentsPerPost = forumData.getAverageCommentsPerPost();
    }


    private void currentlyTestedAssertions(double expectedPostsPerUser,double expectedCommentsPerUser, double expectedCommentsPerPost){
        Assertions.assertEquals(expectedPostsPerUser, averagePostsPerUser, 0.01);
        Assertions.assertEquals(expectedCommentsPerUser, averageCommentsPerUser,0.01);
        Assertions.assertEquals(expectedCommentsPerPost, averageCommentsPerPost,0.01);
    }

    @Nested
    @ExtendWith(MockitoExtension.class)
    public class calculateAdvStatisticsTestSuite {




        @Test
        void testCalculateAdvStatisticsWherePostNoIs0() {

            WhenThenSetup(0,0,0);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(0,0,0);           //Then

            WhenThenSetup(0,1,1);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(-1,-1,-1);        //Then

            WhenThenSetup(0,1,0);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(-1,-1,-1);        //Then

            WhenThenSetup(0,0,1);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(0,0,0);           //Then
        }

        @Test
        void testCalculateAdvStatisticsWherePostNoIs1000() {

            WhenThenSetup(1000,0,0);                                              //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(-1,-1,-1);        //Then

            WhenThenSetup(1000,0,1);                                              //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( 1000,0,0);       //Then

            WhenThenSetup(1000,1,1);                                              //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( 1000,
                    1,(double) 1/1000);                                  //Then

            WhenThenSetup(1000,1,0);                                              //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( -1,-1,-1);       //Then
        }

        @Test
        void testCalculateAdvStatisticsWhereCommentsNoIs0() {


            WhenThenSetup(0,0,0);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(0,0,0);           //Then

            WhenThenSetup(10,0,1);                                                //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( 10,0,0);         //Then

            WhenThenSetup(1,0,0);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( -1, -1,-1);      //Then

            WhenThenSetup(0,0,11);                                                //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( 0,0,0);          //Then
        }

        @Test
        void testCalculateAdvStatisticsWhereCommentsNoIsLowerThatPosts() {

            WhenThenSetup(8,4,0);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(-1,-1,-1);        //Then

            WhenThenSetup(8,4,1);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( 8,4,(double) 1/2);//Then

            WhenThenSetup(2,0,1);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( 2, 0,0);         //Then

        }

        @Test
        void testCalculateAdvStatisticsWhereCommentsNoIsHigherThatPosts() {

            WhenThenSetup(2,4,0);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(-1,-1,-1);        //Then

            WhenThenSetup(2,4,1);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( 2,4,2);          //Then

            WhenThenSetup(0,4,1);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( -1, -1,-1);      //Then
        }


        @Test
        void testCalculateAdvStatisticsWhereUsersNoIs0() {

            WhenThenSetup(0,0,0);                                                 //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(0,0,0);           //Then

            WhenThenSetup(10,0,0);                                                //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( -1,-1,-1);       //Then

            WhenThenSetup(10,10,0);                                               //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(-1 , -1,-1);      //Then

        }

        @Test
        void testCalculateAdvStatisticsWhereUsersNoIs100() {

            WhenThenSetup(0,0,100);                                               //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions(0,0,0);           //Then

            WhenThenSetup(10,0,100);                                                //Given
            dataAssign();                                                                                           //When
            currentlyTestedAssertions( (double) 1/10,0,0);//Then

            WhenThenSetup(20,10,100);                                             //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( (double) 20/100,
                    (double) 10/100,(double) 1/2);                       //Then

            WhenThenSetup(0,10,100);                                              //Given
            dataAssign();                                                                                         //When
            currentlyTestedAssertions( -1,-1,-1);       //Then
        }
    }

}

