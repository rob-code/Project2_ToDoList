package com.codeclan.todolist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TaskListTest {

    TaskList list;
    Task task1;
    Task task2;
    Task task3;

    @Before
    public void before(){
        task1 = new Task("Shopping", "Get razor blades", "Personal", false);
        task2 = new Task("Wash Car", "Must get more soap", "Car", true);
        task3 = new Task("Make bed", "Why O WHy", "Bedroom", false);
        list = new TaskList();
        list.addTask(task1);
        list.addTask(task2);
        list.addTask(task3);

    }

    @Test
    public void canGetNumberOfTasksInList(){
        assertEquals(3, list.numberOfTasks());
    }

    @Test
    public void canGetNumberOfCompletedTasksInList(){
        assertEquals(1,list.numberOfCompletedTasks());
    }

    @Test
    public void canGetNumberOfIncompleteTasksInList(){
        assertEquals(2, list.numberOfIncompleteTasks());

    }



}
