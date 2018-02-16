package com.kodilla.patterns2.observer.homework;

import java.util.*;

public class StudentHomeworks implements Observable {

    private final String studentName;
    private final Deque<String> homeworksLinks;
    private final List<Observer> observers;

    public StudentHomeworks(String studentName) {
        homeworksLinks = new ArrayDeque<>();
        observers = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addHomework(String homeworkLink) {
        homeworksLinks.add(homeworkLink);
        notifyObserver();
    }

    @Override
    public void registryObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        observers.stream()
                .forEach(o -> o.update(this));
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getStudentName() {
        return studentName;
    }

    public Deque<String> getHomeworksLinks() {
        return homeworksLinks;
    }
}
