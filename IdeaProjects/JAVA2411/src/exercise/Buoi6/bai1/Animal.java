package exercise.Buoi6.bai1;

import java.util.Scanner;

public abstract class Animal {
    private String name;
    private int age;

    public void eat() {
        System.out.println("Animal is eating");
    }
    public abstract void makeSound();

    public abstract void action();
    public void showInfo(String name,int age){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

    }
}
