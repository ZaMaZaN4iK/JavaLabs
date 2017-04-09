package com.by.Zaitsev.Main;
import java.util.ArrayDeque;

public class Parking {

    public ArrayDeque<Car> cars = new ArrayDeque<Car>();
    public final int maxSize = 3;
    public int size = 0;

    public static final Parking parking = new Parking();

    public synchronized boolean AddQueue(Car car) {
        if (size < maxSize && cars.isEmpty()) {
            size++;
            return true;
        }
        else {
            cars.add(car);
            return false;
        }
    }

    public synchronized void pop() {
        System.out.println("Появилось место");
        size--;
        if (!cars.isEmpty()){
            cars.poll().parking();
        }
    }

    public synchronized void del(Car car) {
        cars.remove(car);
        System.out.println(car.name + " не дождалась");
    }
}
