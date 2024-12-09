package lesson.lesson6.BaiTap;

public abstract class Animal {
    private String name;
    private int age;

    public void eat() {
        System.out.println("Animal is eating");
    }
    public abstract void makeSound();

    public abstract void action();
}
