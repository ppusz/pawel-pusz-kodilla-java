package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        String toDoTask = "Do somenthing";
        String inProgressTask = "Somenthing in progress";
        String doneTask = "Something done";
        board.getToDoList().getTasks().add(toDoTask);
        board.getInProgressList().getTasks().add(inProgressTask);
        board.getDoneList().getTasks().add(doneTask);

        //Then
        int toDoListSize = board.getToDoList().getTasks().size();
        int inProgressListSize = board.getInProgressList().getTasks().size();
        int doneListSize = board.getDoneList().getTasks().size();
        Assert.assertEquals(1,toDoListSize);
        Assert.assertEquals(1,inProgressListSize);
        Assert.assertEquals(1,doneListSize);

        String readToDoTask = board.getToDoList().getTasks().get(toDoListSize - 1);
        String readInProgressTask = board.getInProgressList().getTasks().get(inProgressListSize - 1);
        String readDoneTask = board.getDoneList().getTasks().get(doneListSize - 1);
        System.out.println(readToDoTask);
        System.out.println(readInProgressTask);
        System.out.println(readDoneTask);
        Assert.assertEquals(toDoTask, readToDoTask);
        Assert.assertEquals(inProgressTask, readInProgressTask);
        Assert.assertEquals(doneTask, readDoneTask);
    }
}
