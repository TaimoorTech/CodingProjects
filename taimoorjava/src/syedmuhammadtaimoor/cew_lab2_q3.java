package syedmuhammadtaimoor;

import java.util.ArrayList;

public class cew_lab2_q3 {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(44);
        integerArrayList.add(67);
        integerArrayList.add(59);
        integerArrayList.add(23);
        integerArrayList.add(96);
        integerArrayList.add(100);
        System.out.println("Before Deleting 3rd Item : " + integerArrayList);
        integerArrayList.remove(2);
        System.out.println("Before Deleting 3rd Item : " + integerArrayList);
    }
}
