package com.codeclan.todolist;


import java.util.ArrayList;

public class SeedList {

    private Task task;
    private ArrayList<Task> seedList;

    public SeedList() {

        seedList = new ArrayList<Task>();

        Task task1 = new Task("Paper", "Get the good news", "Shopping", false);
        Task task2 = new Task("Coffee", "Percolata", "Shopping", true);
        Task task3 = new Task("Tea", "The best from Sri Lanka", "Shopping", true);
        Task task4 = new Task("Bread", "Gluten free", "Shopping", false);
        Task task5 = new Task("Soya milk", "Stop drinking milk!", "Shopping", true);
        Task task6 = new Task("Crisps", "An anti-item. Stop buying these things!!", "Shopping", true);
        Task task7 = new Task("Crowbar", "Take down the wall", "DIY", false);
        Task task8 = new Task("Impact driver", "Get those stuck screws out", "DIY", false);
        Task task9 = new Task("Movies with Jane", "Must get more soap", "Fun", true);
        Task task10 = new Task("Mums birthday", "Must get more soap", "Fun", true);
        Task task11 = new Task("Book Air BnB", "We've got the £100 voucher", "Holidays", true);
        Task task12 = new Task("Change bike tyres", "Jane's bike!", "Bikes", true);

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
