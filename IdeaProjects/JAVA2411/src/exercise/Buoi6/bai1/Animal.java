package exercise.Buoi6.bai1;


public abstract class Animal {
    private String name;
    private int age;

    public void eat() {
        System.out.println("Animal is eating");
    }
    public abstract void makeSound();

    public abstract void action();
    public void showInfo(){
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
}
