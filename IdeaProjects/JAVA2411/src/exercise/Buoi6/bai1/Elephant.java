package exercise.Buoi6.bai1;

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
        System.out.println("The elephant is spraying water.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
    }
}
