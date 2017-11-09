package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class StatisticsCalculatorTestSuite {

    private Statistics getStatisticsMock(ArrayList<String> userNames, int postsCount, int commentsCount) {
        Statistics statisticsMock = Mockito.mock(Statistics.class);
        Mockito.when(statisticsMock.usersNames()).thenReturn(userNames);
        Mockito.when(statisticsMock.postsCount()).thenReturn(postsCount);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        return statisticsMock;
    }

    @Test
    public void testCalculateAdvStatisticsNoPosts() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        String[] arrayUsers = {"admin", "john", "waduhek"};
        ArrayList<String> users = new ArrayList<String>(Arrays.asList(arrayUsers));
        int posts = 0;
        int comments = 0;
        Statistics statisticsMock = getStatisticsMock(users, posts, comments);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        int postsCount = statisticsCalculator.getPostsCount();
        double avgPosts = statisticsCalculator.getAveragePostsPerUser();

        //Then
        Assert.assertEquals(0, postsCount);
        Assert.assertEquals(0., avgPosts, 0);
    }

    @Test
    public void testCalculateAdvStatisticsPostsExist() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        String[] arrayUsers = {"admin", "john", "waduhek", "shroud"};
        ArrayList<String> users = new ArrayList<String>(Arrays.asList(arrayUsers));
        int posts = 1000;
        int comments = 500;
        Statistics statisticsMock = getStatisticsMock(users, posts, comments);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        int postsCount = statisticsCalculator.getPostsCount();
        double avgPosts = statisticsCalculator.getAveragePostsPerUser();

        //Then
        Assert.assertEquals(1000, postsCount);
        Assert.assertEquals(250, avgPosts, 0);
    }

    @Test
    public void testCalculateAdvStatisticsNoComments() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        String[] arrayUsers = {"admin", "john", "waduhek"};
        ArrayList<String> users = new ArrayList<String>(Arrays.asList(arrayUsers));
        int posts = 456;
        int comments = 0;
        Statistics statisticsMock = getStatisticsMock(users, posts, comments);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        int commentsCount = statisticsCalculator.getCommentsCount();
        double avgCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();
        double avgCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();

        //Then
        Assert.assertEquals(0, commentsCount);
        Assert.assertEquals(0, avgCommentsPerPost, 0);
        Assert.assertEquals(0, avgCommentsPerUser, 0);
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        String[] arrayUsers = {"admin", "john", "waduhek"};
        ArrayList<String> users = new ArrayList<String>(Arrays.asList(arrayUsers));
        int posts = 20;
        int comments = 10;
        Statistics statisticsMock = getStatisticsMock(users, posts, comments);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        double avgCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        Assert.assertEquals(0.5, avgCommentsPerPost, 0.000001);
    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        String[] arrayUsers = {"admin", "john", "waduhek"};
        ArrayList<String> users = new ArrayList<String>(Arrays.asList(arrayUsers));
        int posts = 25;
        int comments = 50;
        Statistics statisticsMock = getStatisticsMock(users, posts, comments);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        double avgCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        Assert.assertEquals(2, avgCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsNoUsers() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<String> users = new ArrayList<String>();
        int posts = 0;
        int comments = 0;
        Statistics statisticsMock = getStatisticsMock(users, posts, comments);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        int usersCount = statisticsCalculator.getUsersCount();
        double avgPosts = statisticsCalculator.getAveragePostsPerUser();
        double avgCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();
        double avgCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();

        //Then
        Assert.assertEquals(0, usersCount);
        Assert.assertEquals(0, avgPosts, 0);
        Assert.assertEquals(0, avgCommentsPerPost, 0);
        Assert.assertEquals(0, avgCommentsPerUser, 0);
    }

    @Test
    public void testCalculateAdvStatisticsUsersExist() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        String[] arrayUsers = new String[100];
        for (int i = 0; i < arrayUsers.length; i++) {
            arrayUsers[i] = "User " + (i + 1);
        }
        ArrayList<String> users = new ArrayList<String>(Arrays.asList(arrayUsers));
        int posts = 1000;
        int comments = 2000;
        Statistics statisticsMock = getStatisticsMock(users, posts, comments);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        int usersCount = statisticsCalculator.getUsersCount();
        double avgPosts = statisticsCalculator.getAveragePostsPerUser();
        double avgCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();

        //Then
        Assert.assertEquals(100, usersCount);
        Assert.assertEquals(10, avgPosts, 0);
        Assert.assertEquals(20, avgCommentsPerUser, 0);
    }
}
