package com.by.Zaitsev.Main;


public class Car extends Thread{

    public String name;
    public long time;
    public boolean parking;

    public Car(String name, long time) {
        this.name = name;
        this.time = time;
        this.parking = false;
    }

    @Override
    public void run() {
        System.out.println(name + " приехала");
        if (Parking.parking.AddQueue(this)){
            parking();
        } else {
            System.out.println(name + " стала в очередь");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}

            if (!parking){
                Parking.parking.del(this);
            }
        }

    }

    public void parking(){
        try {
            this.parking = true;
            System.out.println(name + " припарковалась на " + time);
            Thread.sleep(time);
            System.out.println(name + " уехала с парковки");
            Parking.parking.pop();
        } catch (InterruptedException e) { }
    }
}
