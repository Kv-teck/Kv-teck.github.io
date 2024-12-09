package exercise.Buoi6.bai1;

public class Lion extends Animal {
    public void roar() {
        System.out.println("Lion is roaring");
    }

    @Override
    public void makeSound() {
        System.out.println("Lion is roaring.");
    }

    @Override
    public void action() {
        System.out.println("The lion is hunting.");
    }

    @Override
    public void showInfo(String name, int age) {
        super.showInfo(name, age);
    }
}
