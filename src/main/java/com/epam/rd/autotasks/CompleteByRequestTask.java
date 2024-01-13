package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    private boolean complete,execute;
    @Override
    public void execute() {
        if (complete)
            execute=true;
    }

    @Override
    public boolean isFinished() {
        return (execute);
    }

    public void complete() {
        complete=true;
    }
}