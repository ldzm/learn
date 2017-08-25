package com.github.ldzm.nio;

import java.util.ArrayList;
import java.util.List;

public class C {

    static class A{

    }

    static class B extends  A{

    }

    public static void main(String[] args) {
        ArrayList<A> list=new ArrayList<A>();
        list.add(new B());
        method1(list);
    }

    public static void method1(List<? super A> list){
        for(int i=0;i<list.size();i++){
            A a= (A)list.get(0);
        }
    }
}