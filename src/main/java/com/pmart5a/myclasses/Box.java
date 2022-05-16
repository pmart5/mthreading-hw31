package com.pmart5a.myclasses;

public class Box {

    public static final int FREQUENCY_OF_INCLUSION = 2000;
    public static final int NUMBER_OF_ITERATIONS = 7;
    private volatile boolean tumbler = false;

    public boolean isTumbler() {
        return tumbler;
    }

    public void setTumbler(boolean tumbler) {
        this.tumbler = tumbler;
    }

    public void turnOn() {
        try {
            for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
                if (!isTumbler()) {
                    System.out.printf("%s: включаю тумблер.;-)\n", Thread.currentThread().getName());
                    setTumbler(true);
                }
                Thread.sleep(FREQUENCY_OF_INCLUSION);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.currentThread().interrupt();
    }

    public void turnOff() {
        while (true) {
            if(Thread.currentThread().isInterrupted()) {
                return;
            }
            if (isTumbler()) {
                System.out.printf("%s: выключаю тумблер.:-O\n", Thread.currentThread().getName());
                setTumbler(false);
            }
        }
    }
}