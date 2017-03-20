package com.codeclan.todolist;


import java.util.ArrayList;

public class SeedTasks {

    private Task task;
    private ArrayList<Task> taskList;

    public SeedTasks() {

        taskList = new ArrayList<Task>();

        Task task1 = new Task("Paper", "Get the good news", "Shopping", false);
        Task task2 = new Task("Coffee", "Percolata", "Shopping", true);
        Task task3 = new Task("Tea", "The best from Sri Lanka", "Shopping", true);
        Task task4 = new Task("Bread", "Gluten free", "Shopping", false);
        Task task5 = new Task("Soya milk", "Stop drinking milk!", "Shopping", true);
        Task task6 = new Task("Crisps", "An anti-item. Stop buying these things!!", "Shopping", true);
        Task task7 = new Task("Crowbar", "Take down the wall", "DIY", false);
        Task task8 = new Task("Impact driver", "Get those stuck screws out", "DIY", false);
        Task task9 = new Task("Movies with Jane", "Go and see something she will like", "Fun", true);
        Task task10 = new Task("IB's birthday", "Must get present", "Fun", true);
        Task task11 = new Task("Book Air BnB", "We've got the £100 voucher", "Holidays", true);
        Task task12 = new Task("Change bike tyres", "Jane's bike!", "Bikes", true);

        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);
        taskList.add(task5);
        taskList.add(task6);
        taskList.add(task7);
        taskList.add(task8);
        taskList.add(task9);
        taskList.add(task10);
        taskList.add(task11);
        taskList.add(task12);
    }

    public ArrayList<Task> getSeedTasks(){
        return this.taskList;
    }


}
