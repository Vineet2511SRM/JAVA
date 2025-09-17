package WEEK6.LAB;

// LAB PROBLEM 1: Fruit and Apple Classes
class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    public void showFruitInfo() {
        System.out.println("Fruit Color: " + color);
        System.out.println("Fruit Taste: " + taste);
    }
}

class Apple extends Fruit {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    public void showAppleInfo() {
        System.out.println("Apple Variety: " + variety);
        // inherited fields directly
        System.out.println("Apple Color: " + color);
        System.out.println("Apple Taste: " + taste);
    }
}

public class LabProblem1 {
    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");

        // show info
        a.showAppleInfo();
        System.out.println("---- Checking via parent method ----");
        a.showFruitInfo(); // optional, to prove inheritance
    }
}
