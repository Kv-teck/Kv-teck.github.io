package lesson.lesson6.BaiTap;

public class Elephant extends Animal {
    public void trumpet(){
        System.out.println("Elephant is trumpeting");
    }

    @Override
    public void makeSound() {
        System.out.println("Elephant is trumpeting.");
    }

    @Override
    public void action() {

    }
}
