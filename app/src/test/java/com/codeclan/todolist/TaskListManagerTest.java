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
    Task task5;
    Task task6;
    Task task7;
    Task task8;
    Task task9;
    Task task10;
    Task task11;
    Task task12;

    @Before
    public void before(){
        task1 = new Task("Coffee", "The best kind", "Shopping", false);
        task2 = new Task("Tea", "All the way from India", "Shopping", true);
        task3 = new Task("Change tyres", "On Jane's bike", "Bike", false);
        task4 = new Task("Bread", "Gluten free", "Shopping", false);
        task5 = new Task("Beans", "Baked", "Shopping", true);
        task6 = new Task("Crisps", "Stop buying these things!!", "Shopping", true);
        task7 = new Task("Crowbar", "Take down the wall", "DIY", false);
        task8 = new Task("Impact driver", "Get those stuck screws out", "DIY", false);
        task9 = new Task("Movies with J", "Go and see something she will like", "Fun", true);
        task10 = new Task("IB's birthday", "Must get present", "Fun", true);
        task11 = new Task("Book Air BnB", "We've got the £100 voucher", "Holidays", true);
        task12 = new Task("Change bike tyres", "J's bike!", "Bikes", true);

        testList = new ArrayList<Task>();

        testList.add(task1);
        testList.add(task2);
        testList.add(task3);
        testList.add(task4);
        testList.add(task5);
        testList.add(task6);
        testList.add(task7);
        testList.add(task8);
        testList.add(task9);
        testList.add(task10);
        testList.add(task11);
        testList.add(task12);

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
          //  System.out.println(testList.get(i).getName() + " " + testList.get(i).getDescription());
        }

        task4 = new Task("Cooking", "Go on holiday", "Family", true);
        listManager.overWriteTask(task1, task4);

        testList = listManager.getList();
        for (int i = 0; i < testList.size(); i++){
          //  System.out.println(testList.get(i).getName() + " " + testList.get(i).getDescription());
        }

    }

    @Test
    public void canSortListByCategory(){
        testList = listManager.getList();
        for (int i = 0; i < testList.size(); i++){
          //  System.out.println(testList.get(i).getName() + " " + testList.get(i).getDescription());
        }

        System.out.println(" ");
        System.out.println(" ");

        testList = listManager.sortByCategory();

        testList = listManager.getList();
        for (int i = 0; i < testList.size(); i++){
         //   System.out.println(testList.get(i).getName() + " " + testList.get(i).getDescription());
        }

    }

    @Test
    public void canSortListByIsDone(){
        testList = listManager.getList();
        for (int i = 0; i < testList.size(); i++){
            System.out.println(testList.get(i).getName() + " " + testList.get(i).getDescription());
        }

        System.out.println(" ");
        System.out.println(" ");

        testList = listManager.sortByIsDone();

        testList = listManager.getList();
        for (int i = 0; i < testList.size(); i++){
            System.out.println(testList.get(i).getName() + " " + testList.get(i).getDescription());
        }

    }


}
