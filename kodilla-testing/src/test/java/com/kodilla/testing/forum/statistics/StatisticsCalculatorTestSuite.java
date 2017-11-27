package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Arrays;

public class StatisticsCalculatorTestSuite {

    private Statistics statisticsMock;
    private StatisticsCalculator statisticsCalculator;

    @Before
    public void setUp() throws Exception {
        String[] arrayUsers = {"admin", "john", "waduhek"};
        ArrayList<String> usersNames = new ArrayList<String>(Arrays.asList(arrayUsers));
        int postsCount = 0;
        int commentsCount = 0;

        statisticsMock = Mockito.mock(Statistics.class);
        Mockito.when(statisticsMock.usersNames()).thenReturn(usersNames);
        Mockito.when(statisticsMock.postsCount()).thenReturn(postsCount);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        statisticsCalculator = new StatisticsCalculator();
    }

    @Test
    public void testCalculateAdvStatisticsNoPosts() {
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        int postsCount = statisticsCalculator.getPostsCount();
        Double avgPosts = statisticsCalculator.getAveragePostsPerUser();

        //Then
        Assert.assertEquals(0, postsCount);
        Assert.assertEquals(new Double(0), avgPosts);
    }

    @Test
    public void testCalculateAdvStatisticsPostsExist() {
        //Given
        int posts = 1000;
        Mockito.when(statisticsMock.postsCount()).thenReturn(posts);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        int postsCount = statisticsCalculator.getPostsCount();
        Double avgPosts = statisticsCalculator.getAveragePostsPerUser();

        //Then
        Assert.assertEquals(1000, postsCount);
        Assert.assertEquals(new Double(1000/3.), avgPosts );
    }

    @Test
    public void testCalculateAdvStatisticsNoComments() {
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        int commentsCount = statisticsCalculator.getCommentsCount();
        Double avgCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();
        Double avgCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();

        //Then
        Assert.assertEquals(0, commentsCount);
        Assert.assertEquals(new Double(0), avgCommentsPerPost);
        Assert.assertEquals(new Double(0), avgCommentsPerUser);
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts() {
        //Given
        int posts = 20;
        int comments = 10;
        Mockito.when(statisticsMock.postsCount()).thenReturn(posts);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(comments);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        Double avgCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        Assert.assertEquals(new Double(0.5), avgCommentsPerPost);
    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        //Given
        int posts = 25;
        int comments = 50;
        Mockito.when(statisticsMock.postsCount()).thenReturn(posts);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(comments);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        Double avgCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        Assert.assertEquals(new Double(2), avgCommentsPerPost);
    }

    @Test
    public void testCalculateAdvStatisticsNoUsers() {
        //Given
        ArrayList<String> users = new ArrayList<String>();
        Mockito.when(statisticsMock.usersNames()).thenReturn(users);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        int usersCount = statisticsCalculator.getUsersCount();
        Double avgPosts = statisticsCalculator.getAveragePostsPerUser();
        Double avgCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();
        Double avgCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();

        //Then
        Assert.assertEquals(0, usersCount);
        Assert.assertEquals(new Double(0), avgPosts);
        Assert.assertEquals(new Double(0), avgCommentsPerPost);
        Assert.assertEquals(new Double(0), avgCommentsPerUser);
    }

    @Test
    public void testCalculateAdvStatisticsUsersExist() {
        //Given
        String[] arrayUsers = new String[100];
        for (int i = 0; i < arrayUsers.length; i++) {
            arrayUsers[i] = "User " + (i + 1);
        }
        ArrayList<String> users = new ArrayList<String>(Arrays.asList(arrayUsers));
        Mockito.when(statisticsMock.usersNames()).thenReturn(users);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        int usersCount = statisticsCalculator.getUsersCount();

        //Then
        Assert.assertEquals(100, usersCount);
    }
}
