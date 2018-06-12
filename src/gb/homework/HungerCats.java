package gb.homework;

/**
 * @author Andrey Knyazev
 * @version dated by 12.06.2018
 */

public class HungerCats {

    public static void main(String[] args) {
        Plate plate = new Plate((int) (Math.random() * 30));
        Cat catArray[] = {new Cat("Barsik", (int) (Math.random() * 10)),
                new Cat("Murzik", (int) (Math.random() * 10)),
                new Cat("Pushok", (int) (Math.random() * 10)),
                new Cat("Ryzhik", (int) (Math.random() * 10)),
                new Cat("Chernish", (int) (Math.random() * 10))};
        for (Cat cat : catArray) {
            cat.eat(plate);
            System.out.println(cat.toString());
        }
        System.out.println(plate.toString());
        plate.addFood(20);
        System.out.println(plate.toString());
    }
}

class Cat {

    private String name;
    private int appetite;
    private boolean bellyful;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.bellyful = false;
    }

    void eat(Plate plate) {
        bellyful = (plate.getFood() - appetite >= 0) ? true : false;
        plate.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return name + " Bellyful: " + bellyful;
    }
}

class Plate {

    private int food;

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int food) {
        if (this.food - food < 0) {
            return;
        } else {
            this.food -= food;
        }
    }

    void addFood(int addFood) {
        this.food += addFood;
    }

    @Override
    public String toString() {
        return "Food: " + food;
    }

    int getFood() { // Food getter
        return food;
    }

}