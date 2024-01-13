package com.epam.rd.autotasks;

public class CountDownTask implements Task{
    int countdown;
    public CountDownTask(int value) {
        this.countdown = Math.max(value, 0);
    }

    public int getValue() {
        return countdown;
    }


    @Override
    public void execute() {
        if (!isFinished())
            countdown--;
    }

    @Override
    public boolean isFinished() {
        return (countdown==0);
    }
}