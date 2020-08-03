package hw6.animals;

public class Animal {
    String name;
    int distance;

    public Animal(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void run(int distance) {
        if (distance < 0) {
            System.out.println("Некорректное число");
            return;
        }

        if (this.distance >= distance) {
            System.out.printf("%s пробежал %dм%n", name, distance);
        } else {
            System.out.printf("%s пробежал %dм и упал:)%n", name, this.distance);
        }
    }

    public void swim(int distance) {
        if (distance < 0) {
            System.out.println("Некорректное число");
            return;
        }

        if (this.distance >= distance) {
            System.out.printf("%s проплыл %dм%n", name, distance);
        } else {
            System.out.printf("%s проплыл %dм и утанул:)%n", name, this.distance);
        }
    }

}
