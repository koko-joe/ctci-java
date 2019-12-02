package chapter15;

public class DiningPhilosophers {

    private final static int philosopherCount = 3;
    private final static int bitesPerMeal = 10;

    public static void main(String[] args) {
        Chopstick[] cutlery = new Chopstick[philosopherCount];
        for (int i = 0; i < philosopherCount; ++i) {
            cutlery[i] = new Chopstick(i);
        }

        Philosopher[] philosophers = new Philosopher[philosopherCount];
        for (int i = 0; i < philosopherCount; ++i) {
            Chopstick leftChopstick = cutlery[i];
            Chopstick rightChopstick = cutlery[(i + 1) % philosopherCount];
            philosophers[i] = new Philosopher(leftChopstick, rightChopstick, bitesPerMeal, i);
        }

        for (int i = 0; i < philosopherCount; ++i) {
            philosophers[i].start();
        }
    }
}
