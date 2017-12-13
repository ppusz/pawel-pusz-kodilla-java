package com.kodilla.patterns.prototype;

public final class Task {

    String name;

    public Task(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "      Task [" + name + "]";
    }
}
