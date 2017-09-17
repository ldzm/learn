package com.github.ldzm.concurrent;

import java.util.Random;

/**
 * 代码修改自博客：http://0414.iteye.com/blog/2072256
 * 感谢博主ldz0414的无私奉献
 */
class Student {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class ThreadLocalTest implements Runnable {

    ThreadLocal studentLocal = new ThreadLocal() {
        @Override
        protected Object initialValue() {

            Student student = new Student();
            studentLocal.set(student);

            return student;
        }
    };

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        new Thread(threadLocalTest, "threadLocalTest1").start();
        new Thread(threadLocalTest, "threadLocalTest2").start();
    }

    @Override
    public void run() {
        accessStudent();
    }

    private void accessStudent() {
        Student s = (Student) studentLocal.get();

        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println(Thread.currentThread().getName() + " setAge(age):" + age);

        s.setAge(age);
        System.out.println(Thread.currentThread().getName() + " getAge():" + age);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " getAge() after sleep:" + "" + age);
    }
}
