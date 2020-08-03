package hw6;

import hw6.animals.Animal;
import hw6.animals.Cat;
import hw6.animals.Dog;

public class Main {
    public static void main(String[] args) {

        int catCount = 0;
        int dogCount = 0;

        Animal[] animals = new Animal[5];
        animals[0] = new Cat("Кузя");
        animals[1] = new Dog("Рекс");
        animals[2] = new Cat("Мурзик");
        animals[3] = new Cat("Том");
        animals[4] = new Dog("Марта");

        animals[0].run(120);
        animals[4].run(499);
        animals[2].swim(10);
        animals[1].swim(2);
        animals[3].run(201);

        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                catCount++;
            } else {
                dogCount++;
            }
        }

        System.out.printf("Котов %d, собак %d, всего животных %d%n", catCount, dogCount, animals.length);

    }
}
