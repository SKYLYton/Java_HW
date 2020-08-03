package hw6.animals;

public class Animal {
    String name;
    int distanceRun;
    int distanceSwim;

    public Animal(String name, int distance, int distanceSwim) {
        this.name = name;
        this.distanceRun = distance;
        this.distanceSwim = distanceSwim;
    }

    public void run(int distance) {
        if (distance < 0) {
            System.out.println("Некорректное число");
            return;
        }

        if(distanceRun == 0){
            System.out.println(name + " не смог преодолет дистанцию");
            return;
        }

        if (this.distanceRun >= distance) {
            System.out.printf("%s пробежал %dм%n", name, distance);
        } else {
            System.out.printf("%s пробежал %dм и упал:)%n", name, this.distanceRun);
        }
    }

    public void swim(int distance) {
        if (distance < 0) {
            System.out.println("Некорректное число");
            return;
        }

        if(distanceSwim == 0){
            System.out.println(name + " утанул");
            return;
        }

        if (this.distanceSwim >= distance) {
            System.out.printf("%s проплыл %dм%n", name, distance);
        } else {
            System.out.printf("%s проплыл %dм и утанул:)%n", name, this.distanceSwim);
        }
    }

}
