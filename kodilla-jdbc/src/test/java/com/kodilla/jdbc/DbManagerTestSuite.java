package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {

    private DbManager dbManager;

    @Before
    public void setUp() throws Exception {
        dbManager = DbManager.getInstance();
    }

    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        //When
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT FIRSTNAME, LASTNAME\n");
        stringBuilder.append("FROM USERS U INNER JOIN POSTS P ON U.ID = P.USER_ID\n");
        stringBuilder.append("GROUP BY U.ID\n");
        stringBuilder.append("HAVING COUNT(*) > 1;");
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(stringBuilder.toString());

        //Then
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + ", " + resultSet.getString(2) );
            counter++;
        }
        resultSet.close();
        statement.close();
        Assert.assertEquals(2, counter);
    }
}