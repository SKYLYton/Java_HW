package hw6.animals;

public class Cat extends Animal {

    public Cat(String name) {
        super(name, 200);
    }

    @Override
    public void swim(int distance) {
        if (distance < 0) {
            System.out.println("Некорректное число");
            return;
        }

        System.out.println(name + " утанул");
    }
}
