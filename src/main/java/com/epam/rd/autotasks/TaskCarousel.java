package com.epam.rd.autotasks;


public class TaskCarousel {

    private final int capacity;
    private int numberOfTasks;
    private int currentTask;
    private final Task[] carousel;

    public TaskCarousel(int capacity) {
        this.capacity=capacity;
        carousel=new Task[capacity];
    }

    public boolean addTask(Task task) {
        if (!isFull() && task!=null && !task.isFinished()) {
            carousel[numberOfTasks++]=task;
            return true;
        }
        return false;
    }

    public boolean execute() {
        if (isEmpty())
            return false;

        while (carousel[currentTask].isFinished()){
            if (currentTask++==numberOfTasks)
                currentTask=0;
        }

        carousel[currentTask].execute();
        System.out.println(carousel[currentTask].isFinished());
        if (carousel[currentTask].isFinished()) {
            if (capacity - 1 - currentTask > 0)
                System.arraycopy(carousel, currentTask + 1, carousel, currentTask, capacity - 1 - currentTask);
            numberOfTasks--;
            currentTask--;
        }
        currentTask++;
        if (currentTask>=numberOfTasks)
            currentTask=0;
        return true;
    }

    public boolean isFull() {
        return (numberOfTasks>=capacity);
    }

    public boolean isEmpty() {
        return (numberOfTasks==0);
    }

}