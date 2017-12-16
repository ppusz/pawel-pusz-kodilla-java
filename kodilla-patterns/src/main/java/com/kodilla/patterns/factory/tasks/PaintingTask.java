package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    private String taskName;
    private String color;
    private String whatToPaint;
    private boolean taskExecuted;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        this.taskExecuted = false;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWhatToPaint() {
        return whatToPaint;
    }

    public void setWhatToPaint(String whatToPaint) {
        this.whatToPaint = whatToPaint;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecuted;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing painting task '" + taskName + "' in color " + color + " painting " + whatToPaint );
        this.taskExecuted = true;
    }

}
