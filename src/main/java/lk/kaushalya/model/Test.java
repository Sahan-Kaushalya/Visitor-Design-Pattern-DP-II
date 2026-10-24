package lk.kaushalya.model;

interface  Visitor{
    public void visit(Lion lion);
    public void visit(Elephant elephant);
    public void visit(Dog dog);
}

class EatVisitor implements Visitor{
    @Override
    public void visit(Lion lion) {
        System.out.println("Lion is eating");

    }

    @Override
    public void visit(Elephant elephant) {
        System.out.println("Elephant is eating");
    }

    @Override
    public void visit(Dog dog) {
        System.out.println("Dog is eating");
    }
}

class DrinkVisitor implements Visitor{
    @Override
    public void visit(Lion lion) {
        System.out.println("Lion is drinking");
    }

    @Override
    public void visit(Elephant elephant) {
        System.out.println("Elephant is drinking");
    }

    @Override
    public void visit(Dog dog) {
        System.out.println("Dog is drinking");
    }
}

interface  Animal{
    public void run();
    public void accept(Visitor visitor);
}

class Lion implements Animal{
    @Override
    public void run() {
        System.out.println("Lion is running");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Elephant implements Animal{
    @Override
    public void run() {
        System.out.println("Elephant is running");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Dog implements Animal{
    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
public class Test {
    public static void main(String[] args) {

        Lion lion = new Lion();
        Elephant elephant = new Elephant();
        Dog dog = new Dog();

        System.out.println();
        System.out.println("-------------------");
        System.out.println();

        lion.run();
        elephant.run();
        dog.run();

        System.out.println();
        System.out.println("-------------------");
        System.out.println();

        EatVisitor eatVisitor = new EatVisitor();

        lion.accept(eatVisitor);
        elephant.accept(eatVisitor);
        dog.accept(eatVisitor);

        System.out.println();
        System.out.println("-------------------");
        System.out.println();

        DrinkVisitor drinkVisitor = new DrinkVisitor();

        lion.accept(drinkVisitor);
        elephant.accept(drinkVisitor);
        dog.accept(drinkVisitor);
    }
}