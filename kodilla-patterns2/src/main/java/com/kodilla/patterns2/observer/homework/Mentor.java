package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private int homeworksCount;

    public void update(StudentHomeworks studentHomeworks) {
        System.out.println("Received new homework from student: " + studentHomeworks.getStudentName() +
        ". Link to homework: " + studentHomeworks.getHomeworksLinks().peekLast());
        homeworksCount++;
    }

    public int getHomeworksCount() {
        return homeworksCount;
    }
}
