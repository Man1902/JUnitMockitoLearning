package com.learning.powermockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TaskScheduler {
    public void m1() {
        System.out.println("m1 method invoked.");
    }

    private void m2() {
        System.out.println("m2 method invoked.");
    }
}

public class TaskRunner implements Runnable {
    private Method method;

    private TaskScheduler taskScheduler;

    private Object[] args;

    public TaskRunner(Method method, TaskScheduler taskScheduler, Object[] args) {
        this.method = method;
        this.taskScheduler = taskScheduler;
        this.args = args;
    }

    @Override
    public void run() {
        try {
            System.out.println("Method Name : " + method.getName());
            this.method.invoke(this.taskScheduler, this.args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        TaskScheduler taskScheduler = new TaskScheduler();
        Method method = taskScheduler.getClass().getMethod("m2");
        TaskRunner test = new TaskRunner(method, taskScheduler, null);
        test.run();
    }
}
