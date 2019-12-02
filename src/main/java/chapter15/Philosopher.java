package chapter15;

class Philosopher extends Thread {

    private Chopstick lowerNumberChopStick;

    private Chopstick higherNumberChopStick;

    private int remainingBites;

    private int number;

    Philosopher(Chopstick leftChopStick, Chopstick rightChopStick, int remainingBites, int number) {
        this.remainingBites = remainingBites;
        this.number = number;
        if (leftChopStick.getNumber() < rightChopStick.getNumber()) {
            this.lowerNumberChopStick = leftChopStick;
            this.higherNumberChopStick = rightChopStick;
        } else {
            this.lowerNumberChopStick = rightChopStick;
            this.higherNumberChopStick = leftChopStick;
        }
    }

    private void takeBite() {
        lowerNumberChopStick.pickUp();
        higherNumberChopStick.pickUp();
        System.out.println("Philiosopher " + number + " picked up the cutlery");
        --remainingBites;
        System.out.println("Philiosopher " + number + " took a bite");
        higherNumberChopStick.layAside();
        lowerNumberChopStick.layAside();
        System.out.println("Philiosopher " + number + " lay aside up the cutlery");
    }

    @Override
    public void run() {
        while (remainingBites > 0) {
            takeBite();
        }
    }
}
