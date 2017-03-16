package com.codeclan.todolist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TaskListTest {

    TaskList list;
    Task task1;
    Task task2;
    Task task3;
    Task task4;

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
        assertEquals(3, list.getNumberOfTasks());
    }

    @Test
    public void canGetNumberOfCompletedTasksInList(){
        assertEquals(1,list.getNumberOfCompletedTasks());
    }

    @Test
    public void canGetNumberOfIncompleteTasksInList(){
        assertEquals(2, list.getNumberOfIncompleteTasks());
    }

    @Test
    public void canCreateAndAddNewTaskToList(){
        task4 = new Task("Go to movies", "Exciting", "Pictures", true);
        list.addTask(task4);
        assertEquals(4, list.getNumberOfTasks());
    }

    @Test
    public void canDeleteAllCompletedTasks(){
        list.deleteAllCompletedTasks();
        assertEquals(2, list.getNumberOfTasks());
    }

    @Test
    public void canDeleteAllTasks(){
        list.deleteAllTasks();
        assertEquals(0, list.getNumberOfTasks());
    }

    @Test
    public void canMarkTaskAsComplete(){
        list.markTaskAsComplete(task1);
        assertEquals(2, list.getNumberOfCompletedTasks());
    }

    @Test
    public void canMarkTaskAsIncomplete(){
        list.markTaskAsIncomplete(task2);
        assertEquals(0, list.getNumberOfCompletedTasks());
    }

}
