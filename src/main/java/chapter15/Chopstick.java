package chapter15;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Chopstick {

    private Lock lock;

    private int number;

    Chopstick(int number) {
        lock = new ReentrantLock();
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    void pickUp() {
        lock.lock();
    }

    void layAside() {
        lock.unlock();
    }
}
