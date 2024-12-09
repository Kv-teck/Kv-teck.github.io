package lesson.lesson6.BaiTap;

public class Lion extends Animal{
    public void roar(){
        System.out.println("Lion is roaring");
    }

    @Override
    public void makeSound() {
        System.out.println("Lion is roaring.");
    }

    @Override
    public void action() {

    }
}
