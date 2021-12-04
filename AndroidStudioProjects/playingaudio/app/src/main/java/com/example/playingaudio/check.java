package com.example.playingaudio;



import java.lang.reflect.Field;

public class check {
    public static void main(String[] args) throws IllegalAccessException {
        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            if(fields[i].getName().contains(".mp4")){
                System.out.println(fields[i]);
            }
        }
    }
}
