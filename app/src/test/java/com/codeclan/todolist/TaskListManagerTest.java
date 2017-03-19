package com.codeclan.todolist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class TaskListManagerTest {

    TaskListManager listManager;
    ArrayList<Task> testList;
    Task task1;
    Task task2;
    Task task3;
    Task task4;

    @Before
    public void before(){
        task1 = new Task("Coffee", "The best kind", "Shopping", false);
        task2 = new Task("Tea", "All the way from India", "Shopping", true);
        task3 = new Task("Change tyres", "On Jane's bike", "Bike", false);

        testList = new ArrayList<Task>();
        testList.add(task1);
        testList.add(task2);
        testList.add(task3);

        listManager = new TaskListManager(testList);
    }

    @Test
    public void canGetNumberOfTasksInList(){
        assertEquals(3, listManager.getNumberOfTasks());
    }

    @Test
    public void canGetNumberOfCompletedTasksInList(){
        assertEquals(1,listManager.getNumberOfCompletedTasks());
    }

    @Test
    public void canGetNumberOfIncompleteTasksInList(){
        assertEquals(2, listManager.getNumberOfIncompleteTasks());
    }

    @Test
    public void canCreateAndAddNewTaskToList(){
        task4 = new Task("Go to movies", "Exciting", "Pictures", true);
        listManager.addTask(task4);
        assertEquals(4, listManager.getNumberOfTasks());
    }

    @Test
    public void canDeleteAllCompletedTasks(){
        listManager.deleteAllCompletedTasks();
        assertEquals(2, listManager.getNumberOfTasks());
    }

    @Test
    public void canDeleteAllTasks(){
        listManager.deleteAllTasks();
        assertEquals(0, listManager.getNumberOfTasks());
    }

    @Test
    public void canMarkTaskAsComplete(){
        listManager.markTaskAsComplete(task1);
        assertEquals(2, listManager.getNumberOfCompletedTasks());
    }

    @Test
    public void canMarkTaskAsIncomplete(){
        listManager.markTaskAsIncomplete(task2);
        assertEquals(0, listManager.getNumberOfCompletedTasks());
    }

    @Test
    public void canOverWriteTask(){
        testList = listManager.getList();
        for (int i = 0; i < testList.size(); i++){
            System.out.println(testList.get(i).getName() + " " + testList.get(i).getDescription());
        }

        task4 = new Task("Cooking", "Go on holiday", "Family", true);
        listManager.overWriteTask(task1, task4);

        testList = listManager.getList();
        for (int i = 0; i < testList.size(); i++){
            System.out.println(testList.get(i).getName() + " " + testList.get(i).getDescription());
        }



    }


}
