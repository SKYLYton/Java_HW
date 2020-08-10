package hw7;

public class Cat {
    private String name;
    private boolean full = false;
    private final int AMOUNT;

    public Cat(String name, int amount) {
        this.name = name;
        this.AMOUNT = amount;
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return full;
    }

    public void isCatFull(){
        System.out.println(name + (!full ? " голодный" : " сыт"));
    }

    public int getAMOUNT() {
        return AMOUNT;
    }

    public void eat(Plate plate) {

        if (plate.getFood() < AMOUNT || full) {
            System.out.println(name + (!full ? " не досталось еды" : " сыт"));
            return;
        }

        plate.decreaseFood(AMOUNT);

        full = true;
        System.out.println(name + " наелся");
    }

    public void fear(Dog dog) {
        System.out.println(name + " fear " + dog.getName());
    }
}
