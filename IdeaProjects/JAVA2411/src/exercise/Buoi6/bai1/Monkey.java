package exercise.Buoi6.bai1;

public class Monkey extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Monkey is chattering.");
    }

    @Override
    public void action() {
        System.out.println("The monkey is climbing trees.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
    }
}
