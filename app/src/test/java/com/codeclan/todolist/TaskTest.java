package com.codeclan.todolist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TaskTest {

    Task task1;
    Task task2;

    @Before
    public void before(){
        task1 = new Task("Shopping", "Get razor blades", "Personal", false);
        task2 = new Task("Wash Car", "Must get more soap", "Car", true);
    }

    @Test
    public void canGetNameOfTask() {
        assertEquals("Shopping", task1.getName());
    }

    @Test
    public void canGetDescriptionOfTask() {
        assertEquals("Get razor blades", task1.getDescription());
    }

    @Test
    public void canGetCategoryOfTask() {
        assertEquals("Personal", task1.getCategory());
    }

    @Test
    public void canDetermineIfTaskIsNotDone() {
        assertEquals(false, task1.isDone());
    }

    @Test
    public void canDetermineIfTaskIsDone() {
        assertEquals(true, task2.isDone());
    }

}
