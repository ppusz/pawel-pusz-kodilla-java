package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("New ToDos", "New list of To Do Tasks");
        taskListDao.save(taskList);
        String taskListName = taskList.getListName();

        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(taskListName);

        //Then
        Assert.assertEquals(1, readTaskLists.size());
        String readTaskListName = readTaskLists.get(0).getListName();
        Assert.assertEquals(taskListName, readTaskListName);

        //CleanUp
        taskListDao.delete(taskList);
    }
}
