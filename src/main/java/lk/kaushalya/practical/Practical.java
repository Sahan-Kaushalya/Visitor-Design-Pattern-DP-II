package lk.kaushalya.practical;

interface ShoppingCartVisitor{
    double visit(Book book);
    double visit(Fruit fruit);
    double visit(Beverage beverage);
}

interface ProductItem{
    double accept(ShoppingCartVisitor visitor);
}

class Book implements ProductItem{
    private String title;
    private String isbn;
    private double price;

    public Book(String title, String isbn, double price) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Fruit implements ProductItem{
    private String name;
    private double weight;
    private double pricePerKg;

    public Fruit(String name, double weight, double pricePerKg) {
        this.name = name;
        this.weight = weight;
        this.pricePerKg = pricePerKg;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }
}

class Beverage implements ProductItem{
    private String name;
    private double price;

    public Beverage(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class ShoppingCartVisitorImpl implements ShoppingCartVisitor{

    @Override
    public double visit(Book book) {
        System.out.println("Book: " + book.getTitle() + " ISBN: " + book.getIsbn() + " cost = $" + book.getPrice());
        return book.getPrice();
    }

    @Override
    public double visit(Fruit fruit) {
        System.out.println("Fruit: " + fruit.getName() + " weight = " + fruit.getWeight() +
                "kg cost = $" + fruit.getPricePerKg() * fruit.getWeight());
        return fruit.getPricePerKg() * fruit.getWeight();
    }

    @Override
    public double visit(Beverage beverage) {
        System.out.println("Beverage: " + beverage.getName() + " cost = $" + beverage.getPrice());
        return beverage.getPrice();
    }
}

public class Practical {
    public static void main(String[] args) {
        ProductItem[] items = new ProductItem[]{
                new Book("Design Patterns", "ISBN-1203-4541", 50),
                new Fruit("Apple", 2, 3.0),
                new Beverage("Coke", 3.5),
                new Book("Clean Code", "ISBN-1203-4542", 40),
                new Fruit("Banana", 1.5, 2.0),
                new Beverage("Pepsi", 3.0)
        };

        // Calculate the total price when checkout
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("      Total Cost Calculation     ");
        System.out.println("---------------------------------");
        System.out.println();
        double total = calculatePrice(items);
        System.out.println("---------------------------------");
        System.out.println("Total Cost = $" + total);
        System.out.println("---------------------------------");
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("      Thank you for shopping!     ");
        System.out.println("---------------------------------");
    }

    private static double calculatePrice(ProductItem[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        double sum = 0;
        for (ProductItem item : items) {
            sum += item.accept(visitor);
        }
        return sum;
    }
}
