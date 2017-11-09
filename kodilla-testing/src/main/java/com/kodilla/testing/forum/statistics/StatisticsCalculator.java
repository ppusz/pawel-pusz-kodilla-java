package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        if (usersCount > 0) {
            averagePostsPerUser = ((double) postsCount) / usersCount;
        }
        if (usersCount > 0) {
            averageCommentsPerUser = ((double) commentsCount) / usersCount;
        }
        if (postsCount > 0) {
            averageCommentsPerPost = averageCommentsPerUser / averagePostsPerUser;
        }
    }

    public void showStatistics() {
        StringBuilder sb = new StringBuilder(164);
        sb.append("FORUM STATISTICS\n");
        sb.append("Users count: " + usersCount + "\n");
        sb.append("Posts count: " + postsCount + "\n");
        sb.append("Comments count: " + commentsCount + "\n");
        sb.append("Average posts count per user: " + averagePostsPerUser + "\n");
        sb.append("Average comments count per user: " + averageCommentsPerUser + "\n");
        sb.append("Average comments count per post: " + averageCommentsPerPost );

        System.out.println(sb.toString());
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
