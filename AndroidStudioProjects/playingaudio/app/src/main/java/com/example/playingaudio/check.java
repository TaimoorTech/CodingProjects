package com.example.playingaudio;



import java.lang.reflect.Field;

public class check {
    public static void main(String[] args) throws IllegalAccessException {
        Field[] fields = R.raw.class.getFields();

        System.out.println(fields[0].getName());
        System.out.println(fields[0].getInt(fields[0]));

        System.out.println(fields[1].getName());
        System.out.println(fields[1].getInt(fields[1]));

    }
}
