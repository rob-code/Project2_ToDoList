package com.codeclan.todolist;


import java.util.ArrayList;

public class SeedList {

    private Task task;
    private ArrayList<Task> seedList;

    public SeedList() {

        ArrayList<Task> seedList = new ArrayList<Task>();
        Task task1 = new Task("Shopping", "Get razor blades", "Personal", false);
        Task task2 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task3 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task4 = new Task("Wash Car", "Must get more soap", "Car", false);
        Task task5 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task6 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task7 = new Task("Wash Car", "Must get more soap", "Car", false);
        Task task8 = new Task("Wash Car", "Must get more soap", "Car", false);
        Task task9 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task10 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task11 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task12 = new Task("Wash Car", "Must get more soap", "Car", true);

        seedList.add(task1);
        seedList.add(task2);
        seedList.add(task3);
        seedList.add(task4);
        seedList.add(task5);
        seedList.add(task6);
        seedList.add(task7);
        seedList.add(task8);
        seedList.add(task9);
        seedList.add(task10);
        seedList.add(task11);
        seedList.add(task12);
    }

    public ArrayList<Task> getSeedList(){
        return this.seedList;
    }


}
