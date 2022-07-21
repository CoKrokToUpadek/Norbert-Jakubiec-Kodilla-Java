package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
      void testSelectUsersAndPosts() throws SQLException {
       //Given
       DbManager dbManager = DbManager.getInstance();

       //When
       String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, U.ID, COUNT(U.ID) AS NUMBEROFPOSTS\n" +
               "FROM USERS U\n" +
               "JOIN POSTS P on U.ID = P.USER_ID\n" +
               "GROUP BY U.ID\n" +
               "HAVING NUMBEROFPOSTS>=2";
       Statement statement = dbManager.getConnection().createStatement();
       ResultSet rs = statement.executeQuery(sqlQuery);

       //Then
       int counter = 0;
        System.out.println("firstname/lastname/id/numberOfPosts");
       while (rs.next()) {
           System.out.println(rs.getString("FIRSTNAME") + ", " +
                   rs.getString("LASTNAME") + ", " +
                   rs.getInt("ID")+ ", " +rs.getInt("NUMBEROFPOSTS"));
           counter++;
       }
       rs.close();
       statement.close();
       assertEquals(1, counter);
    }

}