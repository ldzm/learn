package com.github.ldzm.test;

public class TestFinalize {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Hello");
        super.finalize();
    }

    public static void main(String[] args) {
        TestFinalize testFinalize = new TestFinalize();

        testFinalize = null;
        System.gc();

        double num = 1;
        System.out.format("%.8f", num);
    }
}
