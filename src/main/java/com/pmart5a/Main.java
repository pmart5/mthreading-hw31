package com.pmart5a;

import com.pmart5a.myclasses.Box;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Box box = new Box();
        Thread aToy = new Thread(null, box::turnOff, "Поток Игрушка");
        Thread user = new Thread(null, box::turnOn, "Поток Пользователь");
        System.out.printf("Поток %s: поехали...\n", Thread.currentThread().getName());
        aToy.start();
        user.start();
        user.join();
        aToy.interrupt();
        System.out.printf("Поток %s: финита ля комедия.:-)", Thread.currentThread().getName());
    }
}