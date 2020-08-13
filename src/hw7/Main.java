package hw7;

public class Main {
    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Barsik", 8),
                new Cat("Murzik", 7),
                new Cat("Kuzya", 12),
                new Cat("Riziy", 10)
        };
        Plate plate = new Plate(50);
        plate.putFood(37);

        System.out.println(plate);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

        System.out.println(plate);

    }
}
