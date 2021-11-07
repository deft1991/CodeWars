package com.codewars;

import java.util.Arrays;
import java.util.Objects;

/*
 * Created by sgolitsyn on 5/7/20
 */
public class Tets {


    public static void main(String[] args) throws InterruptedException {
        Tets tets = new Tets();
        tets.test2();
        System.gc();
        Thread.sleep(1000);
        System.gc();
        tets.test();
    }

    public void test(){
        PlatformType[] types = new PlatformType[10000000];

        for (int i = 0; i < 10000000; i++){
            types[i] = PlatformType.ios;
        }
        long start = System.currentTimeMillis();
        boolean b = Arrays.stream(PlatformType.values())
                .map(PlatformType::name)
                .anyMatch(it -> Objects.equals(it, PlatformType.android.name()));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public void test2(){

        PlatformType[] types = new PlatformType[10000000];
        for (int i = 0; i < 10000000; i++){
            types[i] = PlatformType.ios;
        }
        long start = System.currentTimeMillis();
        boolean b = Arrays.stream(PlatformType.values())
                .anyMatch(it -> Objects.equals(it.name(), PlatformType.android.name()));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }



    enum PlatformType{
        ios,
        android
    }
}
