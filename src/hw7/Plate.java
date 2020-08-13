package hw7;

public class Plate {
    private int food;
    private final int VOLUME;

    public Plate(int volume) {
        this.VOLUME = volume;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        food -= amount;
    }

    public void putFood(int amount){
        if(amount + food > VOLUME){
            System.out.println("Еда перевалилась за края");
            food = VOLUME;
            return;
        }

        food += amount;
    }

    @Override
    public String toString() {
        return "Plate { " +
                "food = " + food +
                " }";
    }
}
