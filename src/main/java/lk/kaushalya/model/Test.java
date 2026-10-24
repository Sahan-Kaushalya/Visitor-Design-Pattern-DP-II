package lk.kaushalya.model;

interface  Animal{
    public abstract void run();
}

class Lion implements Animal{
    @Override
    public void run() {
        System.out.println("Lion is running");
    }
}

class Elephant implements Animal{
    @Override
    public void run() {
        System.out.println("Elephant is running");
    }
}

class Dog implements Animal{
    @Override
    public void run() {
        System.out.println("Dog is running");
    }
}
public class Test {
    public static void main(String[] args) {

        Lion lion = new Lion();
        Elephant elephant = new Elephant();
        Dog dog = new Dog();

        lion.run();
        elephant.run();
        dog.run();
    }
}